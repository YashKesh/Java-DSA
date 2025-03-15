package Dynamic_programming;
import java.util.*;
/*
 * You are a professional robber planning to rob
 * houses along a street. Each house has a certain
 * amount of money stashed. All houses at this place
 * are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, adjacent
 * houses have a security system connected, and it will
 * automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * Given a list of non-negative integers nums representing
 * the amount of money of each house, return the maximum
 * amount of money you can rob tonight without alerting the police.
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 * because they are adjacent houses.
 * 
 */
public class Houserobber2 {
    public static void main(String[] args) {
        Houserobber2 sol = new Houserobber2();
        System.out.println(sol.rob(new int[]{1,2,3,1}));
    }
        public static int solve(ArrayList<Integer> nums,int[] dp,int n){
            if(n<0){
                return 0;
            }
            if(n==0){
                return nums.get(n);
            }
            if(dp[n]!=0){
                return dp[n];
            }
            int inclu = solve(nums,dp,n-2) + nums.get(n);
            int exclu = solve(nums,dp,n-1);
            int ans = Math.max(inclu,exclu);
            dp[n] = ans;
            return dp[n];
        }

        public int rob(int[] valueInHouse) {
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
            int[] dp1 = new int[first.size()];
            int[] dp2 = new int[second.size()];
            int ans = Math.max(solve(first,dp1,first.size()-1), solve(second,dp2,second.size()-1));
            return ans;
        }
    }

