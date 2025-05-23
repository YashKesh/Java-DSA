package Dynamic_programming;
import java.util.*;
/*
    * Given a number N. Find the minimum number of coins that sum to N.
    * Example:
    * Input: coins = [1,2,3,5], amount = 11
    * Output: 3
    * Explanation: 11 = 5 + 5 + 1
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
        System.out.println(sol.coinChange(new int[]{1,2,3,5},11));
    }
//    class Solution {
        int[] dp;
        public int coinChange(int[] coins, int amount) {

            dp = new int[amount + 1];
            Arrays.fill(dp, -1);
            int ans = coinCount(coins, amount);
            return (ans == Integer.MAX_VALUE) ?  -1 : ans;
        }

        int coinCount(int[] coins, int amount) {

            if(amount == 0) {
                return 0;
            }
            if(amount < 0) {
                return Integer.MAX_VALUE;
            }

            if(dp[amount] != -1) {
                return dp[amount];
            }

            int minCoins = Integer.MAX_VALUE;
            for(int i = 0; i < coins.length; i++) {
                int ans = coinCount(coins, amount - coins[i]);

                if(ans != Integer.MAX_VALUE) {

                    //we have returned 0 in ans, so now we are updating the ans count
                    //hence 1 + ans
                    minCoins = Math.min(minCoins, 1 + ans);
                }
            }
            return dp[amount] = minCoins;
        }

}
