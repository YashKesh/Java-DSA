package Strings;
import java.util.*;
public class ReverseString3 {
    public static void main(String[] args) {
        ReverseString3 sol = new ReverseString3();
        System.out.println(sol.reverseWords("jai Shree ram bolo Jai shree ram "));
    }
//    class Solution {
        public String reverseWords(String s) {
            String[] words = s.split(" ");
            StringBuilder ans = new StringBuilder();
            for(String word: words){
                ans.append(new StringBuilder(word).reverse()).append(" ");
            }
            return ans.toString().trim();
        }
    }
//}
