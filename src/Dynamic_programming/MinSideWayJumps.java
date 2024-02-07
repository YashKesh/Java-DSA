package Dynamic_programming;
import java.util.*;
public class MinSideWayJumps {
    public static void main(String[] args) {
        MinSideWayJumps sol = new MinSideWayJumps();
        System.out.print(sol.minSideJumps(new int[]{0,1,2,3,0}));
    }
        private static int solve(int[] obstacles,int currlane,int pos,int n ,int[][] dp){
            if(pos == n){
                return 0;
            }
            if(dp[currlane][pos]!=-1){
                return dp[currlane][pos];
            }
            if(obstacles[pos+1]!=currlane){
                return solve(obstacles,currlane,pos+1,n,dp);
            }
            else{
                int ans = Integer.MAX_VALUE;
                for(int i = 1;i<=3;i++){
                    if(currlane!=i && obstacles[pos]!=i){
                        ans  = Math.min(ans,1+solve(obstacles,i,pos,n,dp));
                    }}
                dp[currlane][pos] = ans;

            }
            return dp[currlane][pos];
        }
        public int minSideJumps(int[] obstacles) {
            int n = obstacles.length;
            int[][] dp = new int[4][n];
            for(int i = 0;i<4;i++){
                Arrays.fill(dp[i],-1);
            }
            return solve(obstacles,2,0,n-1,dp);
        }

}
