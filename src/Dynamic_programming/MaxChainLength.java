package Dynamic_programming;
import  java.util.*;
public class MaxChainLength {
    public static void main(String[] args) {
        MaxChainLength sol = new MaxChainLength();
        System.out.println(sol.findLongestChain(new int[][]{
                {1, 2},
                {3, 4},
                {2, 3},
                {5, 6},
                {1, 5}
        }));
    }
        public static int solve(int n,int[][] pairs,int index,int prev,int[][] dp){
            if(index==n){
                return 0;
            }
            if(dp[index][prev+1]!=-1){
                return dp[index][prev+1];
            }
            int take =0;
            //    int take = 0;
            if (prev == -1 || pairs[prev][1] < pairs[index][0]) {
                take = 1 + solve(n, pairs, index + 1, index, dp);
            }

            int nottake = 0 + solve(n,pairs,index+1,prev,dp);
            dp[index][prev+1] = Math.max(take,nottake);
            return dp[index][prev+1];
        }
        public int findLongestChain(int[][] pairs) {

            int n = pairs.length;
            Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));
            int[][] dp = new int[n][n+1];
            for(int[] sub:dp){
                Arrays.fill(sub,-1);
            }
            return solve(n,pairs,0,-1,dp);
        }

// class Solution {
//     // public static int solve(int n,int[][] pairs,int index,int prev,int[][] dp){
//     //     if(index==n){
//     //         return 0;
//     //     }
//     //     if(dp[index][prev+1]!=-1){
//     //         return dp[index][prev+1];
//     //     }
//     //     int take =0;
//     // //    int take = 0;
//     //     if (prev == -1 || pairs[prev][1] < pairs[index][0]) {
//     //         take = 1 + solve(n, pairs, index + 1, index, dp);
//     //     }

//     //     int nottake = 0 + solve(n,pairs,index+1,prev,dp);
//     //     dp[index][prev+1] = Math.max(take,nottake);
//     //     return dp[index][prev+1];
//     // }
//      public static int binarysearch(ArrayList<int[]> sub,int[] num){
//         int left  = 0;
//         int right  = sub.size()-1;
//         int mid = (left+right)/2;
//         while(left<right){
//             mid = left + (right-left)/2;
//             if(sub.get(mid)[0]==num[0]){
//                 return mid;
//             }
//             else if(sub.get(mid)[1]<num[0]){
//                 left = mid+1;
//             }
//             else{
//                 right = mid-1;
//             }
//         }
//         return mid;
//     }
//     public int findLongestChain(int[][] pairs) {
//         ArrayList<int[]> sub = new ArrayList<>();
//         Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));
//         sub.add(pairs[0]);
//         for(int i = 1; i < pairs.length; i++){
//             int[] num = pairs[i];
//             if(num[0]>sub.get(sub.size()-1)[1]){
//                 sub.add(num);
//             }
//             else{
//                 int j = binarysearch(sub,num);
//                 sub.set(j,num);
//             }
//         }
//         return sub.size();

//     }

// }
// class Solution {
//     public int binarysearch(ArrayList<int[]> sub, int[] num) {
//         int left = 0;
//         int right = sub.size() - 1;

//         while (left <= right) {
//             int mid = left + (right - left) / 2;

//             if (sub.get(mid)[1] < num[0]) {
//                 left = mid + 1;
//             } else {
//                 right = mid - 1;
//             }
//         }
//         return left;
//     }

//     public int findLongestChain(int[][] pairs) {
//         int n = pairs.length;
//         Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

//         ArrayList<int[]> sub = new ArrayList<>();
//         sub.add(pairs[0]);

//         for (int i = 1; i < pairs.length; i++) {
//             int[] num = pairs[i];
//             if (num[0] > sub.get(sub.size() - 1)[1]) {
//                 sub.add(num);
//             } else {
//                 int j = binarysearch(sub, num);
//                 sub.set(j, num);
//             }
//         }

//         return sub.size();
//     }
// }

}
