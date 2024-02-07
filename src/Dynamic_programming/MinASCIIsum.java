package Dynamic_programming;
import java.util.*;
public class MinASCIIsum {
    public static void main(String[] args) {
        MinASCIIsum sol = new MinASCIIsum();
        System.out.println(sol.minimumDeleteSum("sea","eat"));
    }
//    class Solution {
        public int remainsum(String s,int i){
            int sum = 0;
            while(i<s.length()){
                sum+=s.charAt(i);
                i++;
            }
            return sum;
        }
        public int solve(String s1,String s2,int n,int m,int i,int j,int[][] dp){
            if(i == n && j == m){
                return 0;
            }
            if(i==n && j<m){
                return remainsum(s2,j);
            }
            if(i<n && j==m){
                return remainsum(s1,i);
            }
            if(dp[i][j]!=-1){
                return dp[i][j];
            }
            int ans = 0;
            if(s1.charAt(i)==s2.charAt(j)){
                ans = solve(s1,s2,n,m,i+1,j+1,dp);
            }
            else{
                int first = (int)s1.charAt(i) + solve(s1,s2,n,m,i+1,j,dp);
                int second = (int)s2.charAt(j) +  solve(s1,s2,n,m,i,j+1,dp);
                ans = Math.min(first,second);
            }
            dp[i][j] = ans;
            return ans;
        }
        public int minimumDeleteSum(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();
            int[][] dp = new int[n+1][m+1];
            for(int[] sub:dp){
                Arrays.fill(sub,-1);
            }
            return solve(s1,s2,n,m,0,0,dp);

        }
    }
//}
