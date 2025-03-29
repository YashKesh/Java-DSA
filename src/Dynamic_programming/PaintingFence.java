package Dynamic_programming;
import java.util.*;
/*
    * You are painting a fence of n posts with k different colors. You must paint the posts following these rules:
    * Every post must be painted exactly one color.
    * There cannot be three or more consecutive posts with the same color.
    * Given the two integers n and k, return the number of ways you can paint the fence.
    * Example:
    * Input: n = 3, k = 2
    * Output: 6
    * Explanation: All the possibilities are shown.
    * Please note that painting all the posts red or all the posts green is invalid because there cannot be three or more consecutive posts with the same color.
 */
public class PaintingFence {
    public static void main(String[] args) {
        System.out.print(numberOfWays(4,3));
    }
        static int MOD = 1000000007;
        static int mul(int a,int b){
            return (int) ((1L * a * b) % MOD);
        }
        static int add(int a,int b){
            return (a%MOD + b%MOD)%MOD;
        }
        public static int solve(int n,int k,int[] dp){
            if(n==1){
                return k;
            }
            if(n==2){
                return add(k,mul(k,k-1));
            }
            if(dp[n]!=-1){
                return dp[n];
            }
            dp[n] = add(mul(solve(n-2,k,dp),k-1),mul(solve(n-1, k, dp),k-1));
            return dp[n];
        }
        public static int numberOfWays(int n, int k) {
            // Write your code here.
            int[] dp = new int[n+1];
            Arrays.fill(dp,-1);
            return solve(n,k,dp);
        }
    }

