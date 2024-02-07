package Dynamic_programming;
import java.util.*;
/*
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
A falling path starts at any element in the first row and chooses the element in the next row that is
either directly below or diagonally left/right. Specifically, the next element from position
(row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */
public class FallingPathSum {
    public static void main(String[] args) {
        FallingPathSum sol = new FallingPathSum();
        System.out.println(sol.minFallingPathSum(new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        }));
    }
//    class Solution {
        public static int solve(int[][] matrix, int n, int row, int col, int[][] dp) {
            if (row < 0 || col < 0 || col >= n) {
                return 10^9+7;
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
