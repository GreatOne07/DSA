class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;
        for(int num:nums){
            low=Math.max(low,num);
            high+=num;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(ifSplit(nums,k,mid)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    private boolean ifSplit(int[] nums, int k,int mid){
        int subarray=1;
        int currentsum=0;
        for(int num:nums){
        if(currentsum+num>mid){
            subarray++;
            currentsum=num;
            if(subarray>k){
                return false;
            }
        }
        else{
            currentsum+=num;
        }
        
        }
        return true;
    }
}