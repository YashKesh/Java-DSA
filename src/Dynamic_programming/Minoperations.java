package Dynamic_programming;
import  java.util.*;
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
