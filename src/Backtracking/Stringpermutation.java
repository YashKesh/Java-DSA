package Backtracking;
import java.util.*;
public class Stringpermutation {
    public static void main(String[] args) {
        System.out.println(generatePermutations("bc"));
    }
    public static void solve(char[] string,ArrayList<String> res,int index){
        if(index==string.length){
            res.add(new String(string));
            return;
        }
        for(int i =index;i<string.length;i++){
            char temp = string[i];
            string[i] = string[index];
            string[index] = temp;
            solve(string, res, index+1);
            temp = string[i];
            string[i] = string[index];
            string[index] = temp;
        }

    }
    public static ArrayList<String> generatePermutations(String str) {
        // Write your code here
        ArrayList<String> res = new ArrayList<>();
        char[] string  = str.toCharArray();
        solve(string,res,0);
        Collections.sort(res);
        return res;
    }
}
