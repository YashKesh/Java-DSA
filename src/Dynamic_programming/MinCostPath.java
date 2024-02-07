package Dynamic_programming;
import java.util.*;
public class MinCostPath {
    public static void main(String[] args) {
        System.out.println(minCostPath(new int[][]{{3,4,1,2,},{2,1,8,9},{4,7,8,1}},2,3));
    }

    public static  int solve(int[][] cost,int x,int y,int[][] dp,int row,int col){
        if(row==x && col==y){
            return cost[x][y];
        }
        if(row>=cost.length || col>=cost[0].length){
            return 1000000007;
        }
        if(dp[row][col]!=Integer.MAX_VALUE){
            return dp[row][col];
        }
        int down = cost[row][col] + solve(cost, x, y, dp, row+1, col);
        int right = cost[row][col] + solve(cost, x, y, dp, row, col+1);
        int diagonal = cost[row][col] + solve(cost, x, y, dp, row+1, col+1);
        int ans = Math.min(down, Math.min(right, diagonal));
        dp[row][col] = ans;
        return ans;

    }
    public static int minCostPath(int[][] cost, int x, int y)
    {
        int[][] dp = new int[cost.length][cost[0].length];
        for(int[] sub:dp){
            Arrays.fill(sub,Integer.MAX_VALUE);
        }
        //Your code goes here
        return solve(cost,x-1,y-1,dp,0,0);
    }


}

