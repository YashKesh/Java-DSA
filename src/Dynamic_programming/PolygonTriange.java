package Dynamic_programming;
import java.util.*;
/*
 * Given N, consider a convex N-sided polygon with vertices labelled A[0], A[i], ..., A[N-1] in clockwise order.
 * Then consider a triangulation of the polygon into N-2 triangles. For each triangle, the value of that triangle is the
 * corresponding value of the corresponding vertex in the corresponding triangle. (Value(A, B, C) = A * B * C)
 * For each triangle, we return the product of the values of each vertex of the triangle.  Return the largest possible sum of the
 * values of the vertices .
 */
public class PolygonTriange {
    public static void main(String[] args) {
        PolygonTriange sol = new PolygonTriange();
        System.out.print(sol.minScoreTriangulation(new int[]{1,4,5,7,9,6,3}));
    }

        private static int solve(int[] values,int i ,int j ,int[][] dp){
            if(i+1==j){
                return 0;
            }
            if(dp[i][j]!=-1){
                return dp[i][j];
            }
            int ans  = Integer.MAX_VALUE;
            for(int k =i+1;k<j;k++){
                ans = Math.min(ans,values[i]*values[j]*values[k] + solve(values,i,k,dp)+solve(values,k,j,dp));
            }
            dp[i][j] = ans;
            return dp[i][j];
        }
        public int minScoreTriangulation(int[] values) {
            int n = values.length;
            int[][] dp  = new int[n][n];
            for(int i  = 0;i<n;i++){
                Arrays.fill(dp[i],-1);
            }
            return solve(values,0,n-1,dp);
        }
    }

