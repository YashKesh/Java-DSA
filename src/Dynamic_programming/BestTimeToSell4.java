package Dynamic_programming;
import java.util.*;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class BestTimeToSell4 {
    public static void main(String[] args) {
        BestTimeToSell4 sol = new BestTimeToSell4();
        int[] prices = new int[]{3,2,6,5,0,3};
        System.out.println(sol.maxProfit(2,prices));
    }
//    class Solution {
        public int solve(int[] prices,int index,int buy,int limit,int k,int[][][] dp){
            if(index>=prices.length || limit>=k){
                return 0;
            }
            if(dp[index][buy][limit]!=-1){
                return dp[index][buy][limit];
            }
            int profit = 0;
            if(buy==1){
                profit = Math.max(-prices[index] + solve(prices,index+1,0,limit,k,dp),solve(prices,index+1,1,limit,k,dp));

            }
            else{
                profit = Math.max(+prices[index] + solve(prices,index+1,1,limit+1,k,dp),solve(prices,index+1,0,limit,k,dp));

            }
            dp[index][buy][limit] = profit;
            return profit;
        }
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            int[][][] dp = new int[n][2][k];
            for(int[][] sub:dp){
                for(int[] de :sub){
                    Arrays.fill(de,-1);
                }
            }
            return solve(prices,0,1,0,k,dp);
        }
    }
//}
