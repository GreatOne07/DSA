import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        long k = (long) k1 + k2;

        int maxDiff = 0;

        // Find maximum possible difference
        for (int i = 0; i < nums1.length; i++) {
            maxDiff = Math.max(
                maxDiff,
                Math.abs(nums1[i] - nums2[i])
            );
        }

        long[] freq = new long[maxDiff + 1];

        // Count differences
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            freq[diff]++;
        }

        // Reduce differences from largest to smallest
        for (int d = maxDiff; d > 0 && k > 0; d--) {

            if (freq[d] == 0) {
                continue;
            }

            long count = freq[d];

            // Cost to reduce all values from d to d-1
            if (k >= count) {

                // We can reduce every occurrence by 1
                freq[d] -= count;
                freq[d - 1] += count;

                k -= count;
            }
            else {

                // We don't have enough operations
                // to reduce all of them

                long fullGroups = k / count;
                long remainder = k % count;

                // Reduce all elements by fullGroups
                freq[d] -= count;
                freq[d - (int) fullGroups] += count - remainder;

                // Some elements get one additional reduction
                if (remainder > 0) {
                    freq[d - (int) fullGroups - 1] += remainder;
                }

                k = 0;
            }
        }

        // Calculate answer
        long ans = 0;

        for (int d = 1; d <= maxDiff; d++) {
            ans += freq[d] * d * d;
        }

        return ans;
    }
}