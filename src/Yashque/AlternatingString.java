package Yashque;
import java.util.*;
public class AlternatingString {
    public static void main(String[] args) {
        AlternatingString sol = new AlternatingString();
        System.out.print(sol.reorganizeString("bbababqouhkf"));
    }
        public String reorganizeString(String s) {
            Map<Character, Integer> charCount = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char temp = s.charAt(i);
                charCount.put(temp, charCount.getOrDefault(temp, 0) + 1);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                pq.offer(new int[] { entry.getKey(), entry.getValue() });
            }

            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
                int[] first = pq.poll();
                if (sb.length() == 0 || (char) first[0] != sb.charAt(sb.length() - 1)) {
                    sb.append((char) first[0]);
                    if (--first[1] > 0) {
                        pq.offer(first);
                    }
                } else {
                    if (pq.isEmpty()) {
                        return "";
                    }

                    int[] second = pq.poll();
                    sb.append((char) second[0]);
                    if (--second[1] > 0) {
                        pq.offer(second);
                    }

                    pq.offer(first);
                }
            }

            return sb.toString();
        }


// class Solution {
//     public static void solve(String s,char[] testarray,int index,ArrayList<String> res){
//         char[] ans = new char[s.length()];
//         if(index>s.length()-1){
//         int flag = 0;
//         for(int i = 0;i<testarray.length;i++){
//             if(i>0 && testarray[i] == testarray[i-1]){
//                 flag = 1;
//                 break;
//             }
//         }
//         if(flag == 0){
//             res.add(new String(testarray));
//             return;
//         }
//         else{
//             return;
//         }
//         }
//         for(int i = index;i<s.length();i++){
//             char temp = testarray[index];
//             testarray[index] = testarray[i];
//             testarray[i] = temp;
//             solve(s,testarray,i+1,res);
//             temp = testarray[index];
//             testarray[index] = testarray[i];
//             testarray[i] = temp;
//         }
//         // return ans;

//     }
//     public String reorganizeString(String s) {
//         int index = 0;
//         char[] testarray = s.toCharArray();
//         ArrayList<String> res = new ArrayList<>();
//         solve(s,testarray,0,res);
//         if(res.isEmpty()){
//             return "";
//         }
//         else{
//             return res.get(0);
//         }
//         }
// }
}
