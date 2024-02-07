package Dynamic_programming;
import java.util.*;
public class ReducingDishes {
    public static void main(String[] args) {
        ReducingDishes sol = new ReducingDishes();
        System.out.print(sol.maxSatisfaction(new int[]{-1,5,1,2,-5}));
    }
        private static int solve(int[] satisfaction,int index,int n,int time,int[][] dp){
            if(index==n){
                return 0;
            }
            if(dp[index][time]!=-1){
                return dp[index][time];
            }
            int include = satisfaction[index]*(time+1) + solve(satisfaction,index+1,n,time+1,dp);
            int exclude = solve(satisfaction,index+1,n,time,dp);
            dp[index][time] = Math.max(include,exclude);
            return dp[index][time];
        }
        public int maxSatisfaction(int[] satisfaction) {
            Arrays.sort(satisfaction);
            int n = satisfaction.length;
            int[][] dp = new int[n][n];
            for(int i = 0;i<n;i++){
                Arrays.fill(dp[i],-1);
            }
            return solve(satisfaction,0,n,0,dp);
        }
    }

