package Arrays;
import  java.util.*;
public class SubstringWithKUnique {
    public static void main(String[] args) {
        SubstringWithKUnique sol = new SubstringWithKUnique();
        System.out.println(sol.longestkSubstr("aaabebebdbsjn",3));
    }
    public int longestkSubstr(String s, int k) {
        // code here
        Map<Character,Integer> newmap = new HashMap<>();
        int i = 0 , j = 0;
        int n = s.length();
        int len = Integer.MIN_VALUE;
        while(j<n){
            char temp = s.charAt(j);
            newmap.put(temp,1+newmap.getOrDefault(temp,0));
            if(newmap.size()<k){
                j++;
            }
            else if(newmap.size()==k){
                len = Math.max(len,j-i+1);
                j++;
            }
            else {
                char temp1 = s.charAt(i);
                newmap.put(temp1,newmap.get(temp1)-1);
                i++;
                j++;
                if(newmap.get(temp1)==0){
                    newmap.remove(temp1);
                }
            }
        }
        if(len==Integer.MIN_VALUE){
            return -1;
        }
        else{
            return len;
        }
        // Map<Character, Integer> map = new HashMap<>();
        // int i = 0, j = 0, n = s.length();
        // int len = Integer.MIN_VALUE;
        // while (j < n) {
        //     char c = s.charAt(j);
        //     map.put(c, 1 + map.getOrDefault(c, 0));
        //     if (map.size() < k)
        //         j++;
        //     else if (map.size() == k) {
        //         len = Math.max(len, j - i + 1);
        //         j++;
        //     } else if (map.size() > k) {
        //         char cc = s.charAt(i);
        //         map.put(cc, map.get(cc) - 1);
        //         i++;
        //         j++;
        //         if (map.get(cc) == 0)
        //             map.remove(cc);
        //     }
        // }
        // if(len==Integer.MIN_VALUE){
        //     return -1;
        // }
        // else{
        //     return len;
        // }
    }
}
