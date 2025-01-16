
package SlidingWindow;
import java.util.*;
public class SubStringWithKDistinct{
    public static void main(String[] args) {
        
        String s = "aabacbebebe";
        int k = 3;
        SubStringWithKDistinct sol = new SubStringWithKDistinct();
        System.out.println(sol.longestkSubstr(s, k));
    }
    public int longestkSubstr(String s, int k) {
        // code here
        int i = 0;
        int len = -1;
        Map<Character,Integer> map = new HashMap<>();
        for(int j = 0;j<s.length();j++){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            if(map.size()==k){
                len = Math.max(len , j - i + 1);
            }
            else{
                while(map.size()>k){
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i))==0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
        }
        return map.size() == k ? len : -1;
    }
}