package Dynamic_programming;
import  java.util.*;
/*
    * Given two arrays nums1 and nums2.
    * Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.
    * nums1.length, nums2.length <= 5000
    * nums1, nums2 are non-empty arrays having the same length
    * Example 1:
    * Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
    * Output: 18
 */
public class MaxDotProduct {
        public static void main(String[] args) {
            MaxDotProduct sol = new MaxDotProduct();
            System.out.println(sol.maxDotProduct(new int[]{2,1,-2,5},new int[]{3,0,-6}));
        }
//    class Solution {
        public int solve(int i,int j,int[] nums1,int[] nums2,int n,int m,int[][] dp){
            if(i==n || j==m){
                return 0;
            }
            if(dp[i][j]!=-1){
                return dp[i][j];
            }
            int ans = Integer.MIN_VALUE;
            int take = Integer.MIN_VALUE;
            take = nums1[i]*nums2[j] + solve(i+1,j+1,nums1,nums2,n,m,dp);

            int nottake2 = solve(i+1,j,nums1,nums2,n,m,dp);
            int nottake1 = solve(i,j+1,nums1,nums2,n,m,dp);
            ans = Math.max(take,Math.max(nottake1,nottake2));
            dp[i][j] = ans;
            return ans;
        }
        public int maxDotProduct(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int firstMax = Integer.MIN_VALUE;
            int secondMax = Integer.MIN_VALUE;
            int firstMin = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            for (int num: nums1) {
                firstMax = Math.max(firstMax, num);
                firstMin = Math.min(firstMin, num);
            }

            for (int num: nums2) {
                secondMax = Math.max(secondMax, num);
                secondMin = Math.min(secondMin, num);
            }

            // if (firstMax < 0 && secondMin > 0) {
            //     return firstMax * secondMin;
            // }

            // if (firstMin > 0 && secondMax < 0) {
            //     return firstMin * secondMax;
            // }
            int[][] dp = new int[n][m];
            for(int[] sub:dp){
                Arrays.fill(sub,-1);
            }
            return solve(0,0,nums1,nums2,n,m,dp);
        }
    }
//}
