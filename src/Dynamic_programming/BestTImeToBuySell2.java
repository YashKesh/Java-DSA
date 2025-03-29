package Dynamic_programming;
/*You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock.
You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.
Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.*/
import java.util.*;
public class BestTImeToBuySell2 {
    public static void main(String[] args) {

        BestTImeToBuySell2 sol = new BestTImeToBuySell2();
        System.out.println(sol.maxProfit(new int[]{7,1,5,3,6,4}));
        // System.out.println();
    }
//    class Solution {
        public int solve(int[] prices,int index,int buy,int[][] dp){
            if(index>=prices.length){
                return 0;
            }
            if(dp[index][buy]!=-1){
                return dp[index][buy];
            }
            int profit = 0;

            if(buy==1){
                profit = Math.max(-prices[index] + solve(prices,index+1,0,dp),solve(prices,index+1,1,dp));
            }
            else{
                profit = Math.max(+prices[index] + solve(prices,index+1,1,dp),solve(prices,index+1,0,dp));
            }
            dp[index][buy] = profit;
            return profit;
        }

        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][2];
            for(int[] sub:dp){
                Arrays.fill(sub,-1);
            }
            return solve(prices,0,1,dp);

        }
    }
//}
