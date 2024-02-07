package Dynamic_programming;
import java.util.*;
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

