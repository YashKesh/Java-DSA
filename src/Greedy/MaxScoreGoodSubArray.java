package Greedy;

public class MaxScoreGoodSubArray {
//    public class Solution {
        public int maximumScore(int[] nums, int k) {
            int n = nums.length;
            int left = k;
            int right = k;
            int ans = nums[k];
            int currMin = nums[k];

            while (left > 0 || right < n - 1) {
                if ((left > 0 ? nums[left - 1] : 0) < (right < n - 1 ? nums[right + 1] : 0)) {
                    right++;
                    currMin = Math.min(currMin, nums[right]);
                } else {
                    left--;
                    currMin = Math.min(currMin, nums[left]);
                }

                ans = Math.max(ans, currMin * (right - left + 1));
            }

            return ans;
        }
//    }

//    public class MaximumScoreTest {

        public static void main(String[] args) {
            // Test case
            int[] nums = {1, 4, 3, 4, 5};
            int k = 2;

            MaxScoreGoodSubArray solution = new MaxScoreGoodSubArray();
            int maxScore = solution.maximumScore(nums, k);

            System.out.println("Maximum Score: " + maxScore);
        }
    }

//}
