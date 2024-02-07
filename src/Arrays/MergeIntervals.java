package Arrays;
import  java.util.*;
public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals sol = new MergeIntervals();
        int[][] ans = sol.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

    }
    public int[][] merge(int[][] intervals) {
        Stack<int[]> stack = new Stack<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        for(int[] interval : intervals){
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

