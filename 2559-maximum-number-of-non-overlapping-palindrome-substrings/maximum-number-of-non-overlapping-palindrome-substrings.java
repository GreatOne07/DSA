class Solution {

    public int maxPalindromes(String s, int k) {

        int n = s.length();
        int[] dp = new int[n + 1];

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Skip current index
            dp[i] = Math.max(dp[i], dp[i + 1]);

            // Odd length palindromes
            expand(s, i, i, k, dp);

            // Even length palindromes
            expand(s, i, i + 1, k, dp);
        }

        return dp[0];
    }

    private void expand(String s, int left, int right, int k, int[] dp) {

        int n = s.length();

        while (left >= 0 && right < n &&
               s.charAt(left) == s.charAt(right)) {

            int len = right - left + 1;

            if (len >= k) {
                dp[left] = Math.max(dp[left], 1 + dp[right + 1]);
                break; // shortest valid palindrome is enough
            }

            left--;
            right++;
        }
    }
}