package Dynamic_programming;
import java.util.*;
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum sol = new MinimumPathSum();
        System.out.println(sol.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }
//    class Solution {
        public static int solve(int m,int n,int[][] grid,int row,int col,int[][] dp){
            if(row==m-1 && col == n-1){
                return grid[row][col];
            }
            if(dp[row][col]!=Integer.MAX_VALUE){
                return dp[row][col];
            }
            int rowsum = Integer.MAX_VALUE;
            if(row<m-1){
                rowsum = grid[row][col] + solve(m,n,grid,row+1,col,dp);
            }
            int colsum = Integer.MAX_VALUE;
            if(col<n-1){
                colsum = grid[row][col] +  solve(m,n,grid,row,col+1,dp);
            }
            dp[row][col] = Math.min(dp[row][col],Math.min(rowsum,colsum));
            return dp[row][col];

        }
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            for(int[] sub:dp){
                Arrays.fill(sub,Integer.MAX_VALUE);
            }
            int count = solve(m,n,grid,0,0,dp);
            return count;
        }
    }
//}
