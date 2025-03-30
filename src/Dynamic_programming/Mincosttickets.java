package Dynamic_programming;
import java.util.*;
/*
    * In a country popular for train travel, you have planned some train travelling one year in advance.
    * The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
    * Train tickets are sold in 3 different ways:
    * a 1-day pass is sold for costs[0] dollars;
    * a 7-day pass is sold for costs[1] dollars;
    * a 30-day pass is sold for costs[2] dollars.
    * The passes allow that many days of consecutive travel.
    * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
    * Return the minimum number of dollars you need to travel every day in the given list of days.
    * Example 1:
    * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
    * Output: 11
 */
public class Mincosttickets {
    public static void main(String[] args) {
        Mincosttickets sol = new Mincosttickets();
        System.out.println(sol.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
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
