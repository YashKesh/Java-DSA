package Dynamic_programming;
/*You have n dice, and each die has k faces numbered from 1 to k.
Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice,
so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.
Example 1:

Input: n = 1, k = 6, target = 3
Output: 1
Explanation: You throw one die with 6 faces.
There is only one way to get a sum of 3.*/
import java.util.*;
public class DiceThrowsSum {

        public static final int MOD = 1000000007;

        public int solve(int dice, int faces, int target, int[][] dp) {
            if (target < 0) {
                return 0;
            }
            if (dice == 0) {
                return (target == 0) ? 1 : 0;
            }
            if (dp[dice][target] != -1) {
                return dp[dice][target];
            }

            int ways = 0;
            for (int i = 1; i <= faces; i++) {
                ways = (ways + solve(dice - 1, faces, target - i, dp)) % MOD;
            }

            dp[dice][target] = ways;
            return ways;
        }

        public int numRollsToTarget(int n, int faces, int target) {
            int[][] dp = new int[n + 1][target + 1];
            for (int[] sub : dp) {
                Arrays.fill(sub, -1);
            }
            return solve(n, faces, target, dp);
        }
//    }

}
