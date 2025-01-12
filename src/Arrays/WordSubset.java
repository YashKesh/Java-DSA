package Arrays;
import java.util.*;
public class WordSubset {
    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","o"};
        WordSubset obj = new WordSubset();
        System.out.println(obj.wordSubsets(words1,words2));
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] check = new int[26];
        for(int i = 0;i<words2.length;i++){
            String word = words2[i];
            int[] freq = new int[26];
            for(char ch : word.toCharArray()){
                freq[ch - 'a']++;
                check[ch - 'a'] = Math.max(check[ch - 'a'], freq[ch - 'a']);
            }
            
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0;i<words1.length;i++){
            String word = words1[i];
            int[] freq = new int[26];
            for(char ch : word.toCharArray()){
                freq[ch - 'a']++;
            }
            boolean add = true;
            for(int j = 0;j<26;j++){
                if(check[j] > freq[j]){
                    add = false;
                    break;
                }
            }
            if(add){
                ans.add(word);
            }
        }
        return ans;
    }
}
