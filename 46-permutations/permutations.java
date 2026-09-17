class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length==0){
            res.add(new ArrayList<>());
            return res;
        }
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            int []newnums=new int[nums.length-1];
            int index=0;
            for(int j=0;j<nums.length;j++){
                if(j!=i){
                    newnums[index++]=nums[j];
                }}
                List<List<Integer>>perms=permute(newnums);
                for(List<Integer> p:perms){
                    p.add(0,curr);
                }
                res.addAll(perms);
            
            
        }
        return res;
    }
}