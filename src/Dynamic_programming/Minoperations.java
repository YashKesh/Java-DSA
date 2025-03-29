package Dynamic_programming;
import  java.util.*;
/*
 * You are given two strings s1 and s2 of equal length consisting of letters "0" and "1". 
 * You want to keep s1 as "0" as possible and s2 as "1" as possible.
 * You are allowed to perform the following operation any number of times:
 * Choose two indices (0-indexed) i and j with 0 <= i, j < s1.length and swap s2[i] with s2[j].
 * Return the minimum number of operations required to achieve the desired state.
 * Example:
    * Input: s1 = "1100011000", s2 = "0101001010", x = 2
    * Output: 3
    * Explanation: You can make s1 as "0000011000" and s2 as "1111001010".
    * Constraints:
    * 1 <= s1.length, s2.length <= 1000
    * s1.length == s2.length    
    * 0 <= x <= s1.length
    * s1 and s2 consist of only "0" and "1" characters.
    * The sum of x over all test cases does not exceed 1000.
    * The sum of s1.length over all test cases does not exceed 2000.
 */
public class Minoperations {
    public static void main(String[] args) {
        Minoperations sol = new Minoperations();
        System.out.println(sol.minOperations("1100011000","0101001010",2));
    }
//    class Solution {
        Integer[][] dp;
        public int minOperations(String s1, String s2, int x) {
            int n = s1.length();
            var diff = new ArrayList<Integer>();
            for(int i = 0; i < n; i++){
                if(s1.charAt(i) != s2.charAt(i))
                    diff.add(i);
            }
            System.out.println(diff);
            int m = diff.size();
            if(m % 2 == 1)
                return -1;
            dp = new Integer[m][m];
            return dfs(0, m -1, x, diff);
        }

        int dfs(int l, int r, int x, List<Integer> diff){
            if(l > r)
                return 0;
            if(dp[l][r] != null)
                return dp[l][r];
            int res = Math.min(diff.get(l + 1) - diff.get(l), x) + dfs(l + 2, r, x, diff);
            res = Math.min(res, x + dfs(l + 1, r - 1, x, diff));
            res = Math.min(res, Math.min(diff.get(r) - diff.get(r - 1), x) + dfs(l, r - 2, x, diff));
            return dp[l][r] = res;
        }
    }
//}
