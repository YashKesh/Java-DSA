package Dynamic_programming;
import java.util.*;
/*
You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA
without changing the order of the other characters to make it equal to wordB.
For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2,
word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
Return the length of the longest possible word chain with words chosen from the given list of words.
Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
 */
public class LongestStringChain {
    public static void main(String[] args) {
        LongestStringChain sol = new LongestStringChain();
        System.out.println(sol.longestStrChain(new String[]{"a","ab","cab","cabd","aa"}));
    }
//    class Solution {
        public int longestStrChain(String[] words) {
            Arrays.sort(words,(a,b)->a.length()-b.length());
            Map<String,Integer> map = new HashMap<>();
            int res = 0;
            for(String word:words){
                map.put(word,1);
                for(int i = 0;i<word.length();i++){
                    String temp = word.substring(0,i) + word.substring(i+1);
                    if(map.containsKey(temp)){
                        map.put(word,Math.max(map.get(word),map.get(temp)+1));
                    }
                }
                res = Math.max(res,map.get(word));
            }
            return res;

//        }
    }
}
