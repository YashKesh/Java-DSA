package Dynamic_programming;
import  java.util.*;
/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of
them is that adjacent houses have security systems connected,and it will automatically contact
the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.
 */
public class houserobber {
    public static void main(String[] args) {
        int[] nums = new int[]{7,8,9,24,5,36,4};
        long ans = houseRobber(nums);
        System.out.print(ans);
    }
    public static int solve(int n,int[] dp,int[] nums){
        if(n<0){
            return 0;
        }
        if(n==0){
            return nums[0];
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int inclusive = solve(n-2,dp,nums) + nums[n];
        int exclusive = solve(n-1,dp,nums);
        dp[n] = Math.max(inclusive,exclusive);
        return dp[n];
    }
        public static long solve(ArrayList<Integer> nums){
            long n = nums.size();
            long prev2= 0;
            long prev1 = nums.get(0);
            for(int i = 1;i<n;i++){
                long incl = prev2 + nums.get(i);
                long excl  = prev1 + 0;
                long ans = Math.max(incl, excl);
                prev2 = prev1;
                prev1 = ans;
            }
            return prev1;
        }
        public static long houseRobber(int[] valueInHouse) {
            // Write your code here.
            int n = valueInHouse.length;
            if(n==1){
                return valueInHouse[0];
            }
            ArrayList<Integer> second = new ArrayList<>();
            ArrayList<Integer> first = new ArrayList<>();
            for(int i =0;i<n;i++){
                if(i!=n-1){
                    first.add(valueInHouse[i]);
                }
                if(i!=0){
                    second.add(valueInHouse[i]);
                }
            }
            long ans = Math.max(solve(first), solve(second));
            return ans;
        }
    }

