class Solution {
    public int distinctSubseqII(String s) {
        int mod=1_000_000_007;
        int n=s.length();
        long[] dp=new long[n+1];
        dp[0]=1;
        int[]last=new int[26];
        for(int i=1;i<=n;i++){
            char ch=s.charAt(i-1);
            dp[i]=(2*dp[i-1])% mod;
            if (last[ch - 'a'] != 0) {
                dp[i] = (dp[i] - dp[last[ch - 'a'] - 1] + mod) %mod;
            }
            last[ch - 'a'] = i;
        }
        return (int)((dp[n] - 1 + mod) %mod);
    }
}