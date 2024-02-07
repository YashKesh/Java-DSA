package Arrays;
import  java.util.*;
public class GroupAnagrams {

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> newmap = new HashMap<>();
            List<List<String>> res = new ArrayList<>();
            for(String str :strs){
                char[] testarray = str.toCharArray();
                Arrays.sort(testarray);
                String sorted = new String(testarray);
                if(!newmap.containsKey(sorted)){
                    newmap.put(sorted,new ArrayList<>());
                }
                newmap.get(sorted).add(str);
            }
            res.addAll(newmap.values());
            return res;
        }

         public static void main(String[] args) {
             GroupAnagrams solution = new GroupAnagrams();
             String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
             List<List<String>> result = solution.groupAnagrams(strs);

             for (List<String> group : result) {
                 System.out.println(group);
             }
         }
    }


