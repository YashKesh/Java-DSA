package Dynamic_programming;
import java.util.*;
/*
 * Given a matrix of 0s and 1s, find the largest square submatrix of 1s.
 * If the matrix is not square then the largest square submatrix is returned
 * 
 */
public class SquareFormedInMatrix {
        public static void main(String[] args) {
            SquareFormedInMatrix sol = new SquareFormedInMatrix();
            int n = 2;
            int m = 2;
            int[][] mat = new int[][]{{1,1},{1,1}};
            System.out.print(sol.maxSquare(n,m,mat));
        }

        public int solve(int[][] mat, int i, int j, int[] maxi, int[][] dp) {
            if (i >= mat.length || j >= mat[0].length) {
                return 0;
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            int right = solve(mat, i, j + 1, maxi, dp);
            int diagonal = solve(mat, i + 1, j + 1, maxi, dp);
            int bottom = solve(mat, i + 1, j, maxi, dp);

            dp[i][j] = 0; // Initialize with default value for 0s

            if (mat[i][j] == 1) {
                dp[i][j] = 1 + Math.min(right, Math.min(diagonal, bottom));
                maxi[0] = Math.max(maxi[0], dp[i][j]);
                return dp[i][j];
            } else {
                return dp[i][j] = 0;
            }
        }

        public int maxSquare(int n, int m, int[][] mat) {
            int[][] dp = new int[n][m];
            int[] maxi = new int[1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }
            solve(mat, 0, 0, maxi, dp);
            return maxi[0];
        }



}
