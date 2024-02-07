package Dynamic_programming;
import java.util.*;

public class CutSegments {
    public static void main(String[] args) {
    int n = 7,x=5,y=2,z=2;
    int ans = cutSegments(n,x,y,z);
    System.out.print(ans);

    }
    public static  int solve(int n, int x, int y, int z,int[] dp){
        if(n==0){
            return 0;
        }
        if(n<0){
            return Integer.MIN_VALUE;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int a = solve(n-x, x, y, z, dp)+1;
        int b = solve(n-y, x, y, z, dp)+1;
        int c = solve(n-z, x, y, z, dp)+1;
        dp[n]=Math.max(a, Math.max(c, b));
        return dp[n];
    }
    public static int cutSegments(int n, int x, int y, int z) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = solve(n,x,y,z,dp);
        if(ans<0){
            return 0;
        }
        else{
            return ans;
        }

    }
}
