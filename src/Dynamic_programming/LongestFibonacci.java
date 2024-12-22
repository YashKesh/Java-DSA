package Dynamic_programming;
import  java.util.*;
public class LongestFibonacci {
    public static void main(String[] args) {
        LongestFibonacci sol = new LongestFibonacci();
        System.out.println(sol.lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
    }
    public int solve(int[] arr,int[] dp,int index,int prev,int prev1){
        if(index >= arr.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int take =  0;
        if( arr[index] == prev + prev1){
            take = 1 + solve(arr,dp,index+1,prev1,arr[index]);
        }
        int nottake = solve(arr,dp,index+1,prev,prev1);
        int ans = Math.max(take , nottake);
        dp[index] = ans;
        return ans;

    }
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        if(n <= 1){
            return 1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp , - 1);
        return solve(arr,dp,1, 1,arr[0]);
    }
}
