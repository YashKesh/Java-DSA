package Dynamic_programming;
import java.util.*;
public class longestIncreeasingSub {
    public static void main(String[] args) {
        // longestIncreeasingSub sol = new longestIncreeasingSub();
        int ans = longestSubsequence(5,new int[]{1,2,0,5,6});
        System.out.println(ans);
    }
    public static int solve(int size,int[] a,int index,int prev,int[][] dp){
        if(index==size){
            return 0;
        }
        if(dp[index][prev+1]!=-1){
            return dp[index][prev+1];
        }
        int take = 0;
        if(prev==-1 || a[index]>a[prev]){
            take = 1 + solve(size,a,index+1,index,dp);
        }
        int nottake = solve(size, a, index + 1, prev, dp);
        int ans = Math.max(take,nottake);
        dp[index][prev+1] = ans;
        return ans;
    }
    private static int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
//        int mid = (left + right) / 2;

        while (left < right) {
            int mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }

            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    static int longestSubsequence(int size, int a[])
    {
        // code here
        // int[][] dp = new int[size][size];
        // for(int[] sub:dp){
        //     Arrays.fill(sub,-1);
        // }
        // return solve(size,a,0,-1,dp);
        //  int size = a.length;
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(a[0]);

        for (int i = 1; i < a.length; i++) {
            int num = a[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }

        return sub.size();
    }
}
