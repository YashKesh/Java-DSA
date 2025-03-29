package Dynamic_programming;
/*You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most two transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.*/
import java.util.*;
public class BestTimeToBuySell3 {
    public static void main(String[] args) {
        BestTimeToBuySell3 sol = new BestTimeToBuySell3();
        System.out.println(sol.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
//    class Solution {
        public int solve(int[] prices,int index,int buy,int[][][] dp,int limit){
            if(index>=prices.length || limit>=2){
                return 0;
            }
            if(dp[index][buy][limit]!=-1){
                return dp[index][buy][limit];
            }
            int profit = 0;

            if(buy==1){
                profit = Math.max(-prices[index] + solve(prices,index+1,0,dp,limit),solve(prices,index+1,1,dp,limit));
            }
            else{
                profit = Math.max(+prices[index] + solve(prices,index+1,1,dp,limit+1),solve(prices,index+1,0,dp,limit));
            }
            dp[index][buy][limit] = profit;
            return profit;
        }
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][][] dp = new int[n][2][2];
            for(int[][] sub:dp){
                for(int[] de:sub){
                    Arrays.fill(de,-1);
                }
            }
            return solve(prices,0,1,dp,0);
        }
    }
//}
