package Arrays;

public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray sol = new MaxSubArray();
        System.out.println(sol.maxSubArray(new int[]{-2,-1,2,4,5,-1,4,-2,5,9}));
    }
        public int maxSubArray(int[] nums) {
            int currentSubarray = nums[0];
            int maxSubarray = nums[0];

            // Start with the 2nd element since we already used the first one.
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
                currentSubarray = Math.max(num, currentSubarray + num);
                maxSubarray = Math.max(maxSubarray, currentSubarray);
            }

            return maxSubarray;
        }

}
