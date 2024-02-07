package Dynamic_programming;
/*
62. Unique Paths
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner
(i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.
Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:  */
import java.util.*;
public class UniquePath {

        public int solve(int m,int n,int[][] matrix,int row,int col){
            if(row==m-1 && col==n-1){
                return 1;
            }
            if(matrix[row][col]!=-1){
                return matrix[row][col];
            }
            int count = 0;
            if(row<m-1){
                count = count + solve(m,n,matrix,row+1,col);
            }
            if(col<n-1){
                count = count + solve(m,n,matrix,row,col+1);
            }
            matrix[row][col] = count;
            return matrix[row][col];
        }
        public int uniquePaths(int m, int n) {
            int[][] matrix = new int[m][n];
            for(int[] sub:matrix){
                Arrays.fill(sub,-1);
            }
            int count = solve(m,n,matrix,0,0);
            return count;
        }

    }

