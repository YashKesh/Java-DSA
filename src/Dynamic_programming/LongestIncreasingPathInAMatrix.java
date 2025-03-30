package Dynamic_programming;

import java.util.Arrays;
/*
 * Given a matrix of integers, find the length of the longest increasing path.
 * The length of the path is defined as the number of consecutive integers in the path.
 * If there is no increasing path, return 0.
 * 
 * Example 1:
 * Input: matrix =
 * [ [9,9,4],
 *  [6,6,8],
 * [2,1,1] ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 */

public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        int[][] matrix = 
        {
            {3, 4, 5},
            {3, 2, 6},
            {2, 2, 1}
        };
        LongestIncreasingPathInAMatrix sol = new LongestIncreasingPathInAMatrix();
        System.out.println(sol.longestIncreasingPath(matrix));


    }
    public int solve(int[][] matrix,int row,int col , int[][] dp,int m ,int n){
        if((row == m - 1 && col == n-1) || (row == 0 && col == 0)){
            return 1;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int[] rowm = new int[]{0,0,-1,1};
        int[] colm = new int[]{-1,1,0,0};
        int len = 0;
        for(int k = 0;k<4;k++){
            int newrow = row + rowm[k];
            int newcol = col + colm[k];
            if(newrow >=0 && newcol >=0 && newrow < m && newcol < n && matrix[newrow][newcol] > matrix[row][col]){
                len = Math.max(len , solve(matrix,newrow,newcol,dp,m,n)+1);
            }
        }
        dp[row][col] = len;
        return len;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] sub : dp){
            Arrays.fill(sub , -1);
        }
        int len = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                len = Math.max(len , solve(matrix,i,j,dp,m,n));
            }
        }
        return len;
    }   
}
