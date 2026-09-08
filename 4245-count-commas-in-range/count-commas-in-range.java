class Solution {
    public int countCommas(int n) {
        long ans=0;
        long start=1000;
        int comma =1;
        while(start<=n){
            long end=start*1000+1;
            long count=Math.min((long)n,end)-start+1;
            ans+=count*comma;
            start=start*1000;
            comma++;
        }
        return (int)ans;
    }
}