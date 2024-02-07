package Arrays;

public class FirstandLastPosition {
//    class Solution {
        public static int first(int[] nums, int target) {
            int ans = -1;
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    ans = mid;
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }

        public static int last(int[] nums, int target) {
            int ans = -1;
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    ans = mid;
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }

        public int[] searchRange(int[] nums, int target) {
            return new int[]{first(nums, target), last(nums, target)};
        }
    }

//}
