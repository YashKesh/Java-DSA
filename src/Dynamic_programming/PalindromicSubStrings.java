package Dynamic_programming;
import java.util.*;
/*
    * Given a string, your task is to count how many palindromic substrings in this string.
    * Example 1:
    * Input: s = "abc"
    * Output: 3
    * Explanation: "a", "b", "c" are the 3 palindromic substrings.
    * Example 2:
    * Input: s = "aaa"
    * Output: 6
    * Explanation: "a", "a", "a", "aa", "aa", "aaa" are the 6 palindromic substrings.
 */
public class PalindromicSubStrings {
    public static void main(String[] args) {
        PalindromicSubStrings sol = new PalindromicSubStrings();
        System.out.println(sol.countSubstrings("aaa"));
    }
        public int countSubstrings(String s) {
            int[][] dp = new int[s.length()][s.length()];
            for(int[] sub:dp){
                Arrays.fill(sub,-1);
            }
            int count = 0;
            for(int i = 0;i<s.length();i++){
                for(int j = i;j<s.length();j++){
                    count += solve(s,i,j,dp);
                }
            }
            return count;
        }
        public int solve(String s ,int i ,int j,int[][] dp){
            if(i>=j){
                return 1;
            }
            if(dp[i][j]!=-1){
                return dp[i][j];
            }
            int ans = 0;
            if(s.charAt(i)==s.charAt(j)){
                ans = solve(s,i+1,j-1,dp);
            }
            dp[i][j] = ans;
            return ans;
        }
    }

