package HashMap;
import java.util.*;
public class frequencySort {
    public static void main(String[] args) {
         frequencySort sol = new frequencySort();
        System.out.println(sol.frequencySort("tree"));
    }
        public String frequencySort(String s) {
            Map<Character,Integer> map = new HashMap<>();
            StringBuilder str = new StringBuilder();
            for(int i = 0;i<s.length();i++){
                char ch = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            List<Map.Entry<Character,Integer>> entryList = new ArrayList<>(map.entrySet());
            Collections.sort(entryList,(entry1,entry2)->entry2.getValue().compareTo(entry1.getValue()));
            for(Map.Entry<Character,Integer> entry : entryList){
                for(int i = 0;i<entry.getValue();i++){
                    str.append(entry.getKey());
                }

            }
            return str.toString();

        }
    }
