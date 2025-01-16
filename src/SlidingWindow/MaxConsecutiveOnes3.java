package SlidingWindow;
/*
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array 
 * if you can flip at most k 0's.
 */
public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int k = 2;
        MaxConsecutiveOnes3 sol = new MaxConsecutiveOnes3();
        System.out.println(sol.longestOnes(nums, k));

    }
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = left;
        int n = nums.length;
        int maxLen = 0;
        int zeros = 0;
        while(left < n && right < n){
            if(nums[right]==0){
                zeros++;
            }
            if(zeros > k){
                while(zeros > k ){
                    if(nums[left] == 0){
                        zeros--;
                    }
                    left++;

                }
            }
            maxLen = Math.max(maxLen , right - left +1);
            right++;

        }
        return maxLen;
    }
}
