package Graph;
/*
 * 
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * Example 1:
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not 
 * flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * Example 2:
 * Input: board = [["X"]]
 * Output: [["X"]]
 * Constraints:
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 * 
 */
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

