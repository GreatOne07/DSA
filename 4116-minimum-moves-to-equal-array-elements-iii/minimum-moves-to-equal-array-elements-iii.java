class Solution {
    public int minMoves(int[] nums) {
        int m=nums[0];
        for(int x:nums)
            m=Math.max(m,x);

        int moves=0;
        for(int x:nums){
            moves+=m-x;
        }
        return moves;
    }
}