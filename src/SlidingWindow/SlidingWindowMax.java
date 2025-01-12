package SlidingWindow;
import java.util.PriorityQueue;
/*
 * Given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to 
 * the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 *
 */
class NumPair{
    int num;
    int index;
    NumPair(int num,int index){
        this.num = num;
        this.index = index;
    }
}
public class SlidingWindowMax {
    public static void main(String[] args) {
        SlidingWindowMax sol = new SlidingWindowMax();
        int[] ans = sol.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
         int n = nums.length;
         int[] ans = new int[n-k+1];
         PriorityQueue<NumPair> pq = new PriorityQueue<NumPair>((x,y)-> y.num - x.num);
         for(int i = 0;i<n;i++){
            pq.add(new NumPair(nums[i],i));
            while(!pq.isEmpty()  && pq.peek().index < i - k + 1){
                pq.poll();
            }
            if(i>=k-1){
                ans[i-k+1] = pq.peek().num;
            }
         }   
         return ans;
    }   
}
