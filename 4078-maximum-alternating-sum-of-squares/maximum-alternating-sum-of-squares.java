class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        int posi = (nums.length + 1) / 2;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - posi) {
                ans -= nums[i];
            } else {
                ans += nums[i];
            }
        }
        return ans;
    }
}