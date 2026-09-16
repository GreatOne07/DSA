class Solution {

    int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {

        long[][] dp = new long[k + 1][n];
        long[][] prefix = new long[k + 1][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
            prefix[0][i] = i + 1;
        }

        for (int seg = 1; seg <= k; seg++) {

            for (int end = 1; end < n; end++) {

                dp[seg][end] = (dp[seg][end - 1] + prefix[seg - 1][end - 1]) % MOD;

                prefix[seg][end] = (prefix[seg][end - 1] + dp[seg][end]) % MOD;
            }
        }

        return (int) dp[k][n - 1];
    }
}