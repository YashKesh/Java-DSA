package Strings;
import  java.util.*;
public class MinParaAdd {
    public static void main(String[] args) {
        MinParaAdd obj = new MinParaAdd();
        System.out.println(obj.minAddToMakeValid("()))(("));
    }
        public int minAddToMakeValid(String s) {
            Stack<Character> stack = new Stack<>();
            int extraclosingpara = 0;
            for(char c : s.toCharArray()){
                if(c == '(' &&  extraclosingpara>0){
                    extraclosingpara--;
                }
                else if(!stack.isEmpty() &&  c == ')' && stack.peek()=='('){
                    stack.pop();
                }
                else if(stack.isEmpty() && c == ')'){
                    extraclosingpara++;
                }
                else{
                    stack.push(c);
                }
            }
            return Math.max(stack.size(),extraclosingpara);
        }
    }

