package Dynamic_programming;
import  java.util.*;
public class MinSquares {
    public static void main(String[] args) {
        MinSquares sol = new MinSquares();
        System.out.print(sol.Squares(5));
    }
    public static int solve(int n,int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans = n;
        for(int i =1;i*i<=n;i++){
            ans = Math.min(ans,1 + solve(n-i*i,dp));
        }
        dp[n] = ans;
        return dp[n];

    }
    public int Squares(int n)
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
        // Code here
    }
}
