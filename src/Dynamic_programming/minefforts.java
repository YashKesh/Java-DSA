package Dynamic_programming;
import java.util.*;
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
