package Strings;

public class CanMakeEqual {
    public static void main(String[] args) {
        CanMakeEqual sol = new CanMakeEqual();
        System.out.println(canYouGetSame(8,6,"11100010","110000"));
    }
//    public class Solution {
        public static int solve1(int n,int m,String s,String t,int i,int j){
        if(i>=n-1 && j>=m-1){
            return 1;
        }
        if(i>=n) {
            return 0;
        }
        int ans = 0;
        int take = 0;
        int nottake = 0;
        if(s.charAt(i)==t.charAt(j)){
            take = solve1(n,m,s,t,i+1,j+1);
        }
        else if(s.charAt(i)!=s.charAt(i+1)){
            nottake = solve1(n,m,s,t,i+2,j+1);
        }
        ans = Math.max(take,nottake);
        return ans;
        }
        public static int solve(int n, int m, String s, String t,int i,StringBuilder ans){
            if(i>=n-1){
                return 0;
            }
            if(i<=n-1){
                if(ans.toString().equals(t)){
                    return 1;
                }
            }
            int res = 0;
            if(s.charAt(i)==s.charAt(i+1)){
                ans.append(s.charAt(i));
                return solve(n, m, s, t, i+1, ans);
            }
            if(s.charAt(i)!=s.charAt(i+1)){
                for(int j = 0;j<1;j++){
                    ans.append(Integer.toString(j));
                    int ins = 0;
                    ins = solve(n, m, s, t, i+2, ans);
                    ans.deleteCharAt(ans.length()-1);
                    res = Math.max(ins,res);
                }
            }
            return res;
        }
        static int canYouGetSame(int n, int m, String s, String t) {
            // Write your code here.
            StringBuilder ans = new StringBuilder();
            int sol = solve1(n, m, s, t, 0, 0);
            return sol;

        }
    }
//}
