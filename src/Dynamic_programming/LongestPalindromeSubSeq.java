package Dynamic_programming;
import java.util.Arrays;
public class LongestPalindromeSubSeq {
    public static void main(String[] args) {
        LongestPalindromeSubSeq sol = new LongestPalindromeSubSeq();
        System.out.println(sol.longestPalindromeSubseq("babbbab"));
    }
//    class Solution {
        public static int solve(String s,String rev,int i,int j,int[][] dp,int n){
            if(i==n || j==n){
                return 0;
            }
            if(dp[i][j]!=-1){
                return dp[i][j];
            }
            int ans = 0;
            if(s.charAt(i)==rev.charAt(j)){
                ans = 1 + solve(s,rev,i+1,j+1,dp,n);
            }
            else{
                ans= Math.max(solve(s,rev,i+1,j,dp,n),solve(s,rev,i,j+1,dp,n));
            }
            dp[i][j] = ans;
            return ans;
        }
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            StringBuilder rev = new StringBuilder();
            rev.append(s);
            rev.reverse();
            int[][] dp = new int[n][n];
            for(int[] sub:dp){
                Arrays.fill(sub,-1);
            }
            // System.out.print(rev);
            int count  = solve(s,rev.toString(),0,0,dp,n);
            return count;
        }
    }
//}
