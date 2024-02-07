package Yashque;
import java.util.*;
public class SequentialDigit {
    public static void main(String[] args) {
        SequentialDigit sol = new SequentialDigit();
        System.out.println(sol.sequentialDigits(100,300));
    }
        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> res = new ArrayList<>();
            for(int i = 1;i<=9;i++){
                int num = i;
                int next = i+1;
                while(num<=high && next<=9){
                    num = num*10+next;
                    if(num>=low && num<=high){
                        res.add(num);
                    }
                    next++;
                }
            }
            Collections.sort(res);
            return res;


        }
    }

