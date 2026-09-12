class Solution {

    class Interval {
        int s, e, w, idx;
        Interval(int s, int e, int w, int idx) {
            this.s = s;
            this.e = e;
            this.w = w;
            this.idx = idx;
        }
    }

    class State {
        long weight;
        ArrayList<Integer> list;
        State(long w, ArrayList<Integer> l) {
            weight = w;
            list = l;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        Arrays.sort(arr, (a, b) -> a.e - b.e);

        int[] ends = new int[n + 1];
        for (int i = 1; i <= n; i++)
            ends[i] = arr[i - 1].e;

        int[] prev = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int l = 1, r = i - 1, ans = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (ends[mid] < arr[i - 1].s) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            prev[i] = ans;
        }

        State[][] dp = new State[n + 1][5];

        for (int i = 0; i <= n; i++)
            dp[i][0] = new State(0, new ArrayList<>());

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= 4; k++) {

                State skip = dp[i - 1][k];
                State take = null;

                if (dp[prev[i]][k - 1] != null) {

                    ArrayList<Integer> cur =
                        new ArrayList<>(dp[prev[i]][k - 1].list);

                    int pos = Collections.binarySearch(cur, arr[i - 1].idx);
                    if (pos < 0) pos = -pos - 1;
                    cur.add(pos, arr[i - 1].idx);

                    take = new State(
                        dp[prev[i]][k - 1].weight + arr[i - 1].w,
                        cur
                    );
                }

                dp[i][k] = better(skip, take);
            }
        }

        State ans = new State(0, new ArrayList<>());

        for (int k = 0; k <= 4; k++)
            ans = better(ans, dp[n][k]);

        int[] res = new int[ans.list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = ans.list.get(i);

        return res;
    }

    private State better(State a, State b) {

        if (a == null) return b;
        if (b == null) return a;

        if (a.weight != b.weight)
            return a.weight > b.weight ? a : b;

        int m = Math.min(a.list.size(), b.list.size());

        for (int i = 0; i < m; i++) {
            if (!a.list.get(i).equals(b.list.get(i)))
                return a.list.get(i) < b.list.get(i) ? a : b;
        }

        return a.list.size() <= b.list.size() ? a : b;
    }
}