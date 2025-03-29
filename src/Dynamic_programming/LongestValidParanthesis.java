package Dynamic_programming;
import java.util.*;
/*
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
substring.
 */
public class LongestValidParanthesis {
    public static void main(String[] args) {
        LongestValidParanthesis sol = new LongestValidParanthesis();
        System.out.println(sol.longestValidParentheses("(()"));
    }
        public int longestValidParentheses(String s) {
            Map<Character,Character> map = new HashMap<>();
            map.put('(',')');
            int start = -1;
            int max = 0;
            Stack<Integer> stack = new Stack<>();
            for(int i = 0;i<s.length();i++){
                char temp = s.charAt(i);
                if(map.containsKey(temp)){
                    stack.push(i);
                    if(start==-1){
                        start = i;
                    }
                }
                else{
                    if(!stack.isEmpty()){
                        stack.pop();
                        if(stack.isEmpty()){
                            max  = Math.max(max,i-start+1);
                        }
                        else{
                            max = Math.max(max,i-stack.peek());
                        }
                    }
                    else{
                        start = -1;
                    }
                }

            }
            return max;
        }
    }

