import java.util.*;

class Solution {

    private void dfs(int r, int c, int[][] vis, char[][] board, int[] dr, int[] dc) {

        vis[r][c] = 1;

        int n = board.length;
        int m = board[0].length;

        for (int k = 0; k < 4; k++) {

            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < n &&
                nc >= 0 && nc < m &&
                vis[nr][nc] == 0 &&
                board[nr][nc] == 'O') {

                dfs(nr, nc, vis, board, dr, dc);
            }
        }
    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // First row and last row
        for (int j = 0; j < m; j++) {

            if (board[0][j] == 'O' && vis[0][j] == 0)
                dfs(0, j, vis, board, dr, dc);

            if (board[n - 1][j] == 'O' && vis[n - 1][j] == 0)
                dfs(n - 1, j, vis, board, dr, dc);
        }

        // First column and last column
        for (int i = 0; i < n; i++) {

            if (board[i][0] == 'O' && vis[i][0] == 0)
                dfs(i, 0, vis, board, dr, dc);

            if (board[i][m - 1] == 'O' && vis[i][m - 1] == 0)
                dfs(i, m - 1, vis, board, dr, dc);
        }

        // Flip enclosed O's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}