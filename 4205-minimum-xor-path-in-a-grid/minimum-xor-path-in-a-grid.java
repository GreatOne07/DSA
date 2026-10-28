class Solution {

    public int minCost(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][][] dp = new boolean[m][n][1024];

        // Starting cell
        dp[0][0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                // Skip starting cell
                if (i == 0 && j == 0)
                    continue;

                int value = grid[i][j];

                for (int x = 0; x < 1024; x++) {

                    // Come from above
                    if (i > 0 && dp[i - 1][j][x]) {
                        dp[i][j][x ^ value] = true;
                    }

                    // Come from left
                    if (j > 0 && dp[i][j - 1][x]) {
                        dp[i][j][x ^ value] = true;
                    }
                }
            }
        }

        // Find minimum reachable XOR
        for (int x = 0; x < 1024; x++) {

            if (dp[m - 1][n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}