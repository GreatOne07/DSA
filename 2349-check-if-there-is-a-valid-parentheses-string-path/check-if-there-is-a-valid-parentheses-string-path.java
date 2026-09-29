class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Path contains m + n - 1 cells.
        // Valid parentheses string must have even length.
        if ((m + n) % 2 == 0) {
            return false;
        }

        // First character must be '('
        if (grid[0][0] == ')') {
            return false;
        }

        boolean[][][] dp = new boolean[m][n][m + n + 1];

        // Starting cell
        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                for (int balance = 0; balance <= m + n; balance++) {

                    if (!dp[i][j][balance]) {
                        continue;
                    }

                    // Move DOWN
                    if (i + 1 < m) {

                        int newBalance;

                        if (grid[i + 1][j] == '(') {
                            newBalance = balance + 1;
                        } else {
                            newBalance = balance - 1;
                        }

                        if (newBalance >= 0) {
                            dp[i + 1][j][newBalance] = true;
                        }
                    }

                    // Move RIGHT
                    if (j + 1 < n) {

                        int newBalance;

                        if (grid[i][j + 1] == '(') {
                            newBalance = balance + 1;
                        } else {
                            newBalance = balance - 1;
                        }

                        if (newBalance >= 0) {
                            dp[i][j + 1][newBalance] = true;
                        }
                    }
                }
            }
        }

        // At destination, balance must be exactly 0
        return dp[m - 1][n - 1][0];
    }
}