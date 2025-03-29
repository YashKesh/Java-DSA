package Dynamic_programming;
import java.util.*;
/*
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn].
 * The ball is then at the position [row, column]. The ball is then at the position [startRow, startColumn + 1]. 
 * The ball is then at the position [startRow, startColumn + 2], and so on.
 * The ball moves in all four directions until it hits the wall. When the ball hits a wall, it bounces off the wall 
 * and moves in the opposite direction.
 * Return the number of paths the ball can take to reach the boundary of the grid. The answer is guaranteed to be less than 2^31.
 * Example:
 * Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * Output:
 * 12
    * Explanation:
    * 0 -> 1 -> 2 -> 2 -> 1 -> 1 (right, down, down, right, down, right)
    * 0 -> 1 -> 2 -> 2 -> 0 -> 1 (right, down, down, left, up, right)
    * 0 -> 1 -> 2 -> 1 -> 1 -> 1 (right, down, right, down, right, right)
    * 0 -> 1 -> 2 -> 1 -> 0 -> 1 (right, down, right, down, left, right)
    * 0 -> 1 -> 1 -> 1 -> 1 -> 1 (right, down, right, down, right, right)
    * 0 -> 1 -> 1 -> 1 -> 0 -> 1 (right, down, right, down, left, right)
    * 0 -> 1 -> 1 -> 0 -> 1 -> 1 (right, down, left, down, right, right)
    * 0 -> 1 -> 1 -> 0 -> 0 -> 1 (right, down, left, down, left, right)
    * 0 -> 1 -> 0 -> 1 -> 1 -> 1 (right, down, up, down, right, right)
    * 0 -> 1 -> 0 -> 1 -> 0 -> 1 (right, down, up, down, left, right)
    * 0 -> 1 -> 0 -> 0 -> 1 -> 1 (right, down, up, left, right, right)
    * 0 -> 1 -> 0 -> 0 -> 0 -> 1 (right, down, up, left, up, right)
 */
public class OutOfBoundaryPaths {
    public static void main(String[] args) {
        OutOfBoundaryPaths sol = new OutOfBoundaryPaths();
        System.out.println(sol.findPaths(1,3,3,0,1));
    }
        public static int check(int m, int n, int maxMove, int row, int column,int[][] dp){
            int[] r = {-1,0,1,0};
            int[] c = {0,-1,0,1};
            if((row>=m || column>=n || row<0 || column<0) && maxMove>=0){
                return 1;
            }
            if((row>=m || column>=n || row<0 || column<0) || maxMove<0){
                return 0;
            }
            int steps = 0;
            if(dp[row][column] != -1){
                return dp[row][column];
            }
            for(int i = 0;i<4;i++){
                int newrow =  row + r[i];
                int newcol = column + c[i];
                steps += check(m,n,maxMove-1,newrow,newcol,dp);
            }
            dp[row][column] = steps;
            return steps;
        }
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            int[][] dp = new int[m][n];
            for(int[] sub:dp){
                Arrays.fill(sub,-1);
            }
            int ans = check(m,n,maxMove,startRow,startColumn,dp);
            return ans;
        }
    }

