package Strings;
import java.util.*;
public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords sol = new ReverseWords();
        System.out.println(sol.reverseWords("it is a    good example"));
    }
//    class Solution {
        public String reverseWords(String s) {
            String[] words = s.split(" ");
            Stack<String> stack = new Stack<>();
            for(String str:words){
                if (!str.isEmpty()) {
                    stack.push(str);
                }
            }
            StringBuilder ans  = new StringBuilder();
            while(!stack.isEmpty()){
                ans.append(stack.pop()).append(" ");
            }
            return ans.toString().trim();
        }
    }
//}
