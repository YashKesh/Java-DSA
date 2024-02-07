package Dynamic_programming;
import java.util.*;
public class Mincosttickets {
    public static void main(String[] args) {
        Mincosttickets sol = new Mincosttickets();
    }
//    class Solution {
        public static int solve(int n,int[] days,int[] cost,int index,int[] dp){
            if(index>=n){
                return 0;
            }
            if(dp[index]!=-1){
                return dp[index];
            }
            int first = cost[0] + solve(n, days, cost,index+1, dp);

            int i;

            for(i = index;i<n && days[i]<days[index]+7;i++);

            int second  = cost[1] + solve(n, days, cost, i, dp);

            for(i = index;i<n && days[i]<days[index]+30;i++);

            int third = cost[2] + solve(n, days, cost, i, dp);

            dp[index] = Math.min(first, Math.min(second, third));
            return dp[index];
        }





        public int mincostTickets(int[] days, int[] costs) {
            //Write your code here
            int n  = days.length;
            int[] dp  = new int[n+1];
            Arrays.fill(dp,-1);
            return solve(n, days, costs, 0, dp);
        }

}
