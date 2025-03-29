package Dynamic_programming;
import java.util.*;
/*
 * There is a 3 lane road of length n that consists of n + 1 points labeled from 0 to n. A frog starts at point 0 in the 
 * second lane and wants to jump to point n. However, there could be obstacles along the way.

You are given an array obstacles of length n + 1 where each obstacles[i] (ranging from 0 to 3) describes an obstacle on the lane 
obstacles[i] at point i. If obstacles[i] == 0, there are no obstacles at point i. There will be at most one obstacle in the 3 lanes 
at each point.

For example, if obstacles[2] == 1, then there is an obstacle on lane 1 at point 2.
The frog can only travel from point i to point i + 1 on the same lane if there is not an obstacle on the lane at point i + 1. 
To avoid obstacles, the frog can also perform a side jump to jump to another lane (even if they are not adjacent) at the 
same point if there is no obstacle on the new lane.

For example, the frog can jump from lane 3 at point 3 to lane 1 at point 3.
Return the minimum number of side jumps the frog needs to reach any lane at point n starting from lane 2 at point 0.

Note: There will be no obstacles on points 0 and n.
 */
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
