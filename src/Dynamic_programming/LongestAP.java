package Dynamic_programming;

public class LongestAP {
    public static void main(String[] args) {
        LongestAP sol = new LongestAP();
        System.out.println(sol.longestArithSeqLength(new int[]{1,7,10,13,15,19}));
    }
//    class Solution {
        private static Integer dp[][];

        public int longestArithSeqLength(int[] nums) {
            int result = 0;
            dp = new Integer[nums.length][1001];

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int commonDiff = nums[j] - nums[i];
                    result = Math.max(result, 2 + getLeftPairs(i, commonDiff, nums));
                }
            }

            return result;
        }

        private int getLeftPairs(int idx, int commonDiff, int[] nums) {
            if (idx < 0) {
                return 0;
            }

            if (dp[idx][commonDiff + 500] != null) {
                return dp[idx][commonDiff + 500];
            }

            int result = 0;

            for (int i = idx - 1; i >= 0; i--) {
                if (nums[idx] - nums[i] == commonDiff) {
                    result = Math.max(result, 1 + getLeftPairs(i, commonDiff, nums));
                }
            }

            return dp[idx][commonDiff + 500] = result;
        }
    }
//}
