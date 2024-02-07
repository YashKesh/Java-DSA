package Dynamic_programming;
import java.util.*;
public class MinimumFalligPath {
    public static void main(String[] args) {
    MinimumFalligPath sol = new MinimumFalligPath();
        System.out.println(sol.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
    }
//    class Solution {
        public static int solve(int[][] matrix, int n, int row, int col, int[][] dp) {
            if (row < 0 || col < 0 || col >= n) {
                return Integer.MAX_VALUE;
            }
            if (row == n - 1) {
                return matrix[row][col];
            }
            if (dp[row][col] != Integer.MAX_VALUE) {
                return dp[row][col];
            }
            int ans = Integer.MAX_VALUE; // Initialize ans with Integer.MAX_VALUE
            int down = matrix[row][col] + solve(matrix, n, row + 1, col, dp);
            int right = matrix[row][col] + solve(matrix, n, row + 1, col + 1, dp);
            int left = matrix[row][col] + solve(matrix, n, row + 1, col - 1, dp);
            ans = Math.min(down, Math.min(left, right));
            dp[row][col] = ans;
            return ans;
        }

        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[][] dp = new int[n][n];

            // Initialize dp with Integer.MAX_VALUE
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            int min = Integer.MAX_VALUE;
            for (int col = 0; col < n; col++) {
                min = Math.min(min, solve(matrix, n, 0, col, dp));
            }
            return min;
        }
    }

//}
