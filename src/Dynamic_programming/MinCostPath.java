package Dynamic_programming;
import java.util.*;
/*
    * Given a matrix of integers A with R rows and C columns, find the minimum cost to reach from the cell (0, 0) to the cell (R-1, C-1).
    * You can only move down, right and diagonally lower cells from a given cell, i to a cell j, if i <= j.
    * If two or more paths, have the same cost, then return the path that has the maximum number of cells.
    * If there are more than one path with the maximum number of cells, then return the path that has the maximum 
    value when traversing the cells in the path.
    * If there is no path possible then return an empty array.
    * Input 1:
    * A = [ [3, 4, 1, 2],
    *       [2, 1, 8, 9],
    *       [4,7,8,1] ]
    * Output 1:
    * [1, 2, 3, 4]
 */
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

