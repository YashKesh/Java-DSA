package Dynamic_programming;
import java.util.*;
/*
    * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, 
    where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope 
    to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, 
    and you wish to find a route that requires the minimum effort.
    * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
    * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
    * Example 1:
    * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
    * Output: 2
    * Explanation: The route of [1,3,8,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 */
public class minefforts {
    public static void main(String[] args) {
        minefforts sol = new minefforts();
        System.out.println(sol.minimumEffortPath(new int[][]{{1,2,2},{3,8,2},{5,3,5}}));
    }
//    class Solution {
        public static int solve(int[][] heights,int n ,int m,int row,int col,int[][] dp){
            if(row==n-1 && col == m-1){
                return heights[row][col];
            }
            if(dp[row][col]!=-1){
                return dp[row][col];
            }
            int down = Integer.MAX_VALUE;
            if(row<n-2){
                down = Math.abs(heights[row][col] - solve(heights,n,m,row+1,col,dp));
            }
            int right = Integer.MAX_VALUE;
            if(col<n-2){
                right = Math.abs(heights[row][col] - solve(heights,n,m,row,col+1,dp));
            }
            int up = Integer.MAX_VALUE;
            if(row>0){
                up = Math.abs(heights[row][col] - solve(heights,n,m,row-1,col,dp));
            }
            int left = Integer.MAX_VALUE;
            if(col>0){
                left = Math.abs(heights[row][col] - solve(heights,n,m,row,col-1,dp));
            }
            dp[row][col] = Math.min(down,Math.min(right,Math.min(left,up)));
            return dp[row][col];

        }
        public int minimumEffortPath(int[][] heights) {
            int n = heights.length;
            int m = heights[0].length;
            int[][] dp = new int[heights.length][heights[0].length];
            for(int[] sub:dp){
                Arrays.fill(sub,-1);
            }
            return solve(heights,n,m,0,0,dp);
        }
    }
//}
