package Dynamic_programming;
import  java.util.*;
/*
    * There is a pizza with 3n slices of varying size, you and your friends will take slices of pizza as follows:
    * You will pick any pizza slice.
    * Your friend Alice will pick next slice in anti clockwise direction of your pick.
    * Your friend Bob will pick next slice in clockwise direction of your pick.
    * Repeat the process until you and your friends have taken all n/3 slices.
    * All slices have different size.
    * Return the maximum possible sum of slice sizes which you can have.
    * Example:
    * Input: slices = [1,2,3,4,5,6]
    * Output: 10
    * Constraints:
    * 1 <= slices.length <= 500
    * slices.length % 3 == 0
    * 1 <= slices[i] <= 1000
 */
public class Pizza3Nslices {
    public static void main(String[] args) {
        Pizza3Nslices sol = new Pizza3Nslices();
        System.out.println(sol.maxSizeSlices(new int[]{1,2,6,5,8,4,7,11}));
    }
        public int solve(int n,int start,int end,int[] slices,int limit,int[][] dp){
            if(start>end || limit == 0){
                return 0;
            }
            if(dp[start][limit]!=-1){
                return dp[start][limit];
            }
            int ans = 0;

            int take = slices[start] + solve(n,start+2,end,slices,limit-1,dp);
            int nottake = solve(n, start + 1, end, slices, limit, dp);
            ans = Math.max(take,nottake);

            dp[start][limit] = ans;
            return dp[start][limit];
        }
        public int maxSizeSlices(int[] slices) {
            int n = slices.length;
            int[][] dp1 = new int[n][n];
            for(int[] ddp:dp1){
                Arrays.fill(ddp,-1);
            }
            int[][] dp2 = new int[n][n];
            for(int[] ddp:dp2){
                Arrays.fill(ddp,-1);
            }

            int case1 = solve(n,0,n-2,slices,n/3,dp1);
            int case2 = solve(n,1,n-1,slices,n/3,dp2);
            int ans  = Math.max(case1,case2);
            return ans;
        }

}
