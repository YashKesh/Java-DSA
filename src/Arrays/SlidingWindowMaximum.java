package Arrays;

import java.util.ArrayDeque;
import java.util.Deque;
/*
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        SlidingWindowMaximum sol = new SlidingWindowMaximum();
        int[] result = sol.maxSlidingWindow(nums, k);
        for(int i : result){
            System.out.print(i+" ");
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst() < i - k +1){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                ans[i-k+1] = nums[dq.peekFirst()];
            }
        }       
        return ans;
    }
}
