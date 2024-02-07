package Dynamic_programming;

public class Subsetpartition {
    public static void main(String[] args) {
        Subsetpartition sol = new Subsetpartition();
        System.out.println(sol.canPartition(new int[]{1,5,11,5}));
    }
//    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if (sum % 2 != 0) {
                return false; // If the sum is odd, we cannot partition into two equal subsets.
            }

            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true; // We can always make a sum of 0 without picking any element.

            for (int num : nums) {
                for (int i = target; i >= num; i--) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }

            return dp[target];
        }
    }
//
//}
