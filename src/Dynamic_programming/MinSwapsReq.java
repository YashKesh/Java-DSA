package Dynamic_programming;
import java.util.*;
/*
 * Given two integer arrays `nums1` and `nums2` of the same length, your task is to find the minimum number of swaps required to
 *  make `nums1` equal to `nums2`.

A swap consists of choosing two indices `i` and `j` where `0 <= i < j < nums1.length` and 
swapping the elements at `nums1[i]` and `nums1[j]`.

Return the minimum number of swaps required to make `nums1` equal to `nums2`. If it is not possible, return `-1`.
 */
public class MinSwapsReq {
    public static void main(String[] args) {
        MinSwapsReq spl = new MinSwapsReq();
        System.out.println(spl.minSwap(new int[]{1,2,3,7,6}, new int[]{1,3,4,5,9}));
    }

        public static int solve(ArrayList<Integer> nums1, ArrayList<Integer> nums2, int index, int swapped, int[][] dp) {
            if (index == nums1.size()) {
                return 0;
            }
            if (dp[index][swapped] != -1) {
                return dp[index][swapped];
            }
            int prev1 = nums1.get(index - 1);
            int prev2 = nums2.get(index - 1);
            if (swapped == 1) {
                int temp = prev1;
                prev1 = prev2;
                prev2 = temp;
            }
            int ans = Integer.MAX_VALUE;
            if (nums1.get(index) > prev1 && nums2.get(index) > prev2) {
                ans = solve(nums1, nums2, index + 1, 0, dp);
            }
            if (nums1.get(index) > prev2 && nums2.get(index) > prev1) {
                ans = Math.min(ans, 1 + solve(nums1, nums2, index + 1, 1, dp));
            }
            dp[index][swapped] = ans;
            return ans;
        }

        public int minSwap(int[] nums1, int[] nums2) {
            int n = nums1.length;
            ArrayList<Integer> nums3 = new ArrayList<>();
            nums3.add(-1); // Add -1 as an Integer
            for (int num : nums1) {
                nums3.add(num);
            }

            ArrayList<Integer> nums4 = new ArrayList<>();
            nums4.add(-1); // Add -1 as an Integer
            for (int num : nums2) {
                nums4.add(num);
            }

            int[][] dp = new int[n + 1][2];
            for (int[] sub : dp) {
                Arrays.fill(sub, -1);
            }
            int swapped = 0;
            return solve(nums3, nums4, 1, swapped, dp); // Start index at 0
        }
    }


