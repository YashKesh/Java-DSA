package Arrays;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a string expression of numbers and operators, return all possible results from computing all the 
 * different possible ways to group numbers and operators.
 */
public class DiffWaysToCompute {
    public static void main(String[] args) {
        DiffWaysToCompute sol = new DiffWaysToCompute();
        System.out.println(sol.diffWaysToCompute("2*3-4*5"));
    }
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        int n = expression.length();
        if(n==0){
            return result;
        }   
        if(n==1){
            result.add(Integer.parseInt(expression));
            return result;
        }
        if(n==2 && Character.isDigit(expression.charAt(0))){
             result.add(Integer.parseInt(expression));
             return result;
        }
        for(int i = 0;i<n;i++){
            char current = expression.charAt(i);
            if(Character.isDigit(current)){
                continue;
            }
            List<Integer> leftvals = diffWaysToCompute(expression.substring(0,i));
            List<Integer> rightvals = diffWaysToCompute(expression.substring(i+1));
            for(int lvals : leftvals){
                for(int rvals : rightvals){
                    int computed = 0 ;
                    switch(current){
                        case '+':
                            computed = lvals + rvals;
                            break;
                        case '-':
                            computed = lvals - rvals;
                            break;
                        case '*':
                            computed = lvals * rvals;
                            break;
                    }
                    result.add(computed);
                }

            }
        }
        return result;
    }   
}
