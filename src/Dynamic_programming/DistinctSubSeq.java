package Dynamic_programming;
import java.util.*;
/*
Given two strings s and t, return the number of distinct subsequences of s which equals t.
The test cases are generated so that the answer fits on a 32-bit signed integer.
Example 1:
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit
 */
public class DistinctSubSeq {
    public static void main(String[] args) {
        DistinctSubSeq sol = new DistinctSubSeq();
        System.out.println(sol.numDistinct("rrabbbit","rabbit"));
    }
//    class Solution {
        public static int solve(String s,String t,int j,int index,int[][] dp){
            if(j==t.length()){
                return 1;
            }
            if(index == s.length()){
                return 0;
            }
            if(dp[index][j]!=-1){
                return dp[index][j];
            }
            int count = 0;
            // int include = 0;
            if(s.charAt(index)==t.charAt(j)){
                int include =  solve(s,t,j+1,index+1,dp);
                int exclude = solve(s,t,j,index+1,dp);
                count = include + exclude;
            }
            else{
                count = solve(s,t,j,index+1,dp);
            }

            dp[index][j] = count;
            return count;

        }
        public int numDistinct(String s, String t) {
            int[][] dp = new  int[s.length()][t.length()];
            for(int[] sub :dp){
                Arrays.fill(sub,-1);
            }
            return solve(s,t,0,0,dp);

        }

}
