package Dynamic_programming;
import java.util.*;
/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:
Insert a character
Delete a character
Replace a character
 */
public class EditDistance {
    public static void main(String[] args) {
        EditDistance sol = new EditDistance();
        System.out.println(sol.minDistance("horse","ros"));
    }
//    class Solution {
        public static int solve(String str,String str1,int i ,int j,int[][] dp){
            if(i==str.length() && j==str1.length()){
                return 0;
            }
            if(i==str.length()){
                return str1.length()-j;
            }
            if(j==str1.length()){
                return str.length()-i;
            }
            if(dp[i][j]!=-1){
                return dp[i][j];
            }
            int ans = 0;
            if(str.charAt(i)==str1.charAt(j)){
                ans = solve(str, str1, i + 1, j + 1, dp);
            }
            else{
                int insert = 1 + solve(str,str1,i,j+1,dp);
                int replace = 1 + solve(str,str1,i+1,j+1,dp);
                int delete = 1 + solve(str,str1,i+1,j,dp);
                ans = Math.min(insert,Math.min(delete,replace));
            }
            dp[i][j] = ans;
            return ans;

        }
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length()][word2.length()];
            for(int[] sub:dp){
                Arrays.fill(sub,-1);
            }
            return solve(word1,word2,0,0,dp);
        }

}
