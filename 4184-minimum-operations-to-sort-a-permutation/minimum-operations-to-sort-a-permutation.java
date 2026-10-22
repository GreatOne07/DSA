class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        // -----------------------------
        // CASE 1: nums is a rotation
        // of [0,1,2,...,n-1]
        // -----------------------------

        int zero = 0;

        while (nums[zero] != 0) {
            zero++;
        }

        boolean ok = true;

        for (int i = 0; i < n; i++) {
            if (nums[(zero + i) % n] != i) {
                ok = false;
                break;
            }
        }

        if (ok) {
            // left rotate zero times
            // OR right rotate (n-zero) times
            // right rotation by x costs x + 2
            ans = Math.min(zero, n - zero + 2);
        }


        // -----------------------------
        // CASE 2: reverse(nums) is a
        // rotation of sorted array
        // -----------------------------

        int revZero = n - 1 - zero;

        ok = true;

        for (int i = 0; i < n; i++) {
            int reversedIndex = (revZero + i) % n;
            int originalIndex = n - 1 - reversedIndex;

            if (nums[originalIndex] != i) {
                ok = false;
                break;
            }
        }

        if (ok) {
            ans = Math.min(ans, 1 + Math.min(revZero, n - revZero));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}