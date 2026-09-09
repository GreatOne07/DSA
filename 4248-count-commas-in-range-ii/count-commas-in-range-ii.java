class Solution {
    public long countCommas(long n) {
        long ans=0;
        long start=1000;
        int commas=1;
        while(start<=n){
            long end;
            if (start <= Long.MAX_VALUE / 1000) {
                end = start * 1000 - 1;
            } else {
                end = Long.MAX_VALUE;
            }
            long count=Math.min(n,end)-start+1;
             ans += count * commas;
             if (start > Long.MAX_VALUE / 1000) break;

            start *= 1000;
            commas++;
        }
        return ans;
    }
}