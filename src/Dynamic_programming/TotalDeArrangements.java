package Dynamic_programming;
/*
 * Given a number n, find the total number of derangements possible for the numbers from 1 to n.
 * A derangement is a permutation of the numbers from 1 to n where no element appears in its original position.
 *
 * For example, for n = 3, the derangements are [2, 3, 1], [3, 1, 2], [3, 2, 1].
 *
 * Input:
 */
public class TotalDeArrangements {
    public static void main(String[] args) {
        int n = 5;
        System.out.print(countDerangements(n));
    }
        public static long solve(int n,long[] dp ){
            if(n==1){
                return 0;
            }
            if(n==2){
                return 1;
            }
            if(dp[n]!=0){
                return dp[n];
            }
            dp[n] = ((n-1)*(solve(n-1, dp)+solve(n-2, dp))%1000000007)%1000000007;
            return dp[n];
        }
        public static long countDerangements(int n) {
            // Write your code here.
            long[] dp = new long[n+1];
            return solve(n,dp);
        }
    }

