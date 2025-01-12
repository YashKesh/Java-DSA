package Arrays;
import  java.util.*;
/*
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public static void main(final String[] args) {
        final MergeIntervals sol = new MergeIntervals();
        final int[][] ans = sol.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

    }
    public int[][] merge(final int[][] intervals) {
        final Stack<int[]> stack = new Stack<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        for(final int[] interval : intervals){
            if(stack.isEmpty() || stack.peek()[1]<interval[0]){
                stack.push(interval);
            }
            else{
                stack.peek()[1] = Math.max(stack.peek()[1],interval[1]);
            }
        }
        return stack.toArray(new int[stack.size()][]);
    }
    }
// class Solution {
//     public int[][] merge(int[][] intervals) {
//         int n  = intervals.length;
//         int m  = intervals[0].length;
//         Arrays.sort(intervals, new Comparator<int[]>() {
//             @Override
//             public int compare(int[] a, int[] b) {
//                 return Integer.compare(a[0], b[0]);
//             }
//         });

//         // int[][] res = new int[n][m];
//         List<List<Integer>> res = new ArrayList<>();
//         int i = 0;
//         while(i<n){
//             List<Integer> nums = new ArrayList<>();
//             if(i<n-1 && intervals[i][1]>=intervals[i+1][0]){
//                 nums.add(intervals[i][0]);
//                 nums.add(intervals[i+1][1]);
//                 res.add(nums);
//                 i = i+2;
//             }
//             else{
//                res.add(new ArrayList<>(Arrays.asList(intervals[i][0], intervals[i][1])));
//                 i= i+1;
//             }

//         }
//           int[][] array = new int[res.size()][2];
//           for( i = 0;i<res.size();i++){
//               array[i][0] = res.get(i).get(0);
//               array[i][1] = res.get(i).get(1);
//           }
//           return array;

//     }
// }

