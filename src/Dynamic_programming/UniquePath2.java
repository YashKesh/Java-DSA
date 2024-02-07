package Dynamic_programming;
/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right
at any point in time.
An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */
import java.util.*;
public class UniquePath2 {
    public static void main(String[] args) {
        UniquePath2 sol = new UniquePath2();
        System.out.println(sol.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
//    class Solution {
        public static int solve(int m,int n,int[][] obstacleGrid,int row,int col,int[][] dp){
            if((row>=m-1 && col >= n-1) && obstacleGrid[row][col]!=1){
                return 1;
            }
            if(obstacleGrid[row][col]==1){
                return 0;
            }
            if(dp[row][col]!=-1){
                return dp[row][col];
            }
            int count = 0;
            if(row<m-1){
                count  = count +  solve(m,n,obstacleGrid,row+1,col,dp);;
            }
            if(col<n-1){
                count = count + solve(m,n,obstacleGrid,row,col+1,dp);
            }
            dp[row][col] = count;;
            return dp[row][col];
        }
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            for(int[] sub:dp){
                Arrays.fill(sub,-1);
            }
            int count = solve(m,n,obstacleGrid,0,0,dp);
            return count;
        }
    }
//}
