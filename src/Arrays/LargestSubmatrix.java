package Arrays;
import java.util.*;
/*
You are given a binary matrix, matrix of size m x n,
and you are allowed to rearrange the columns of the matrix in any order.
Return the area of the largest submatrix within matrix where,
every element of the submatrix is 1 after reordering the columns optimally.
 */
public class LargestSubmatrix {
    public static void main(String[] args) {
        LargestSubmatrix sol = new LargestSubmatrix();
        System.out.println(sol.largestSubmatrix(new int[][]{{1,0,1,0,1}}));
    }
        public int largestSubmatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int ans = 0;
            for(int row = 0;row<m;row++){
                for(int col = 0;col<n;col++){
                    if(matrix[row][col]!=0 && row>0){
                        matrix[row][col] += matrix[row-1][col];
                    }
                }
                int[] currow = matrix[row];
                Arrays.sort(currow);
                for (int i = 0; i < currow.length; i++) {
                    ans = Math.max(ans, currow[i] * (n - i));
                }
            }

            return ans;
//            return ans;
        }
    }

