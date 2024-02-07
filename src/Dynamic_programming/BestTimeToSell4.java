package Dynamic_programming;
import java.util.*;
public class BestTimeToSell4 {
    public static void main(String[] args) {
        BestTimeToBuySell3 sol = new BestTimeToBuySell3();
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
