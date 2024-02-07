package Strings;
import java.util.*;
public class PalindromePartitoning {
    public static void main(String[] args) {
        PalindromePartitoning sol = new PalindromePartitoning();
        System.out.println(sol.partition("aab"));
    }
//    class Solution {
        public void check(String s,List<List<String>> ans,List<String> list1,int start){
            if(start>=s.length()){
                ans.add(new ArrayList<>(list1));
            }
            for(int end = start;end<s.length();end++){
                if(ispalindrome(s,start,end)){
                    list1.add(s.substring(start,end+1));
                    check(s,ans,list1,end+1);
                    list1.remove(list1.size()-1);
                }
            }
        }
        public boolean ispalindrome(String s,int start,int end){
            while(start<=end){
                if(s.charAt(start)!=s.charAt(end)){
                    return false;
                }
                start++;
                end--;

            }
            return true;
        }
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            // int start = 0;
            check(s,ans,new ArrayList<>(),0);
            return ans;
        }
    }
//}
