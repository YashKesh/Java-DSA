package Graph;

public class SurroundedRegionSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'O', 'O', 'X', 'X'}
        };

        SurroundedRegionSolver solver = new SurroundedRegionSolver();
        solver.solve(board);

        System.out.println("Updated Board:");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && visited[i][0] == 0) {
                dfs(board, n, m, i, 0, visited);
            }
            if (board[i][m - 1] == 'O' && visited[i][m - 1] == 0) {
                dfs(board, n, m, i, m - 1, visited);
            }
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && visited[0][j] == 0) {
                dfs(board, n, m, 0, j, visited);
            }
            if (board[n - 1][j] == 'O' && visited[n - 1][j] == 0) {
                dfs(board, n, m, n - 1, j, visited);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int n, int m, int row, int col, int[][] visited) {
        visited[row][col] = 1;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
                dfs(board, n, m, nrow, ncol, visited);
            }
        }
    }
}

