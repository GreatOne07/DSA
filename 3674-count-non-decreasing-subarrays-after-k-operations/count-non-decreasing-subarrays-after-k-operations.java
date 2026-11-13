
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        Deque<long[]> dq = new ArrayDeque<>();

        int j = n - 1;

        long cost = 0;
        long ans = 0;

        for (int i = n - 1; i >= 0; i--) {

            int num = nums[i];
            long count = 1;

            // Step 1: Merge smaller groups
            while (!dq.isEmpty() && dq.peekLast()[0] < num) {

                long[] last = dq.pollLast();

                count += last[1];

                cost += (long)(num - last[0]) * last[1];
            }

            // Step 2: Insert the new group
            dq.offerLast(new long[]{num, count});

            // Step 3: Shrink window if cost exceeds k
            while (cost > k) {

                long[] first = dq.pollFirst();

                cost -= first[0] - nums[j];

                j--;

                if (first[1] > 1) {
                    dq.offerFirst(
                        new long[]{first[0], first[1] - 1}
                    );
                }
            }

            // Step 4: Count valid subarrays
            ans += j - i + 1;
        }

        return ans;
    }
}
