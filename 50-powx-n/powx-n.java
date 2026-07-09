class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;          // use long to safely hold -n when n = Integer.MIN_VALUE
        if (nn < 0) nn = -nn;

        while (nn > 0) {
            if (nn % 2 == 1) {         // check nn, not n
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }

        if (n < 0) ans = 1.0 / ans;   // handle negative exponent AFTER loop ends

        return ans;                    // return OUTSIDE the loop, always reached
    }
}