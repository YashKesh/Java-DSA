package Strings;
import java.util.*;
public class minWindowString {
    public static void main(String[] args) {
        minWindowString sol = new minWindowString();
        System.out.println(sol.minWindow("ADOBECODEBANC","ABC"));
    }
        public String minWindow(String s, String t) {
            String ans   = "";
            Map<Character,Integer> map2 = new HashMap<>();
            for(int i = 0;i<t.length();i++){
                char ch  = t.charAt(i);
                map2.put(ch,map2.getOrDefault(ch,0)+1);
            }
            int match = 0;
            int desired = t.length();
            int i = -1;
            int j = -1;
            Map<Character,Integer> map1 = new HashMap<>();
            while( true){
                boolean flag1 = false;
                boolean flag2 = false;
                while(i<s.length()-1 && match<desired){
                    i++;
                    char ch = s.charAt(i);
                    map1.put(ch,map1.getOrDefault(ch,0)+1);
                    if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0)){
                        match++;
                    }
                    flag1= true;
                }
                while(j<i && match==desired){
                    String check = s.substring(j+1,i+1);
                    if(ans.length()==0 || check.length()<ans.length()){
                        ans = check;
                    }
                    j++;
                    char ch = s.charAt(j);
                    if(map1.get(ch)==1){
                        map1.remove(ch);
                    }else{
                        map1.put(ch,map1.get(ch)-1);
                    }
                    if(map1.getOrDefault(ch,0)<map2.getOrDefault(ch,0)){
                        match--;
                    }
                    flag2 = true;
                }
                if(flag1 == false && flag2== false){
                    break;
                }

            }
            return ans;
        }

    }

