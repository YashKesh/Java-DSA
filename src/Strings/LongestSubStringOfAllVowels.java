package Strings;
/*
 * A string is called beautiful if it has all of the following properties:
 * Each letter of the string is a vowel ('a', 'e', 'i', 'o', 'u').
 * A string is called long if it has at least 5 characters.
 * Given a string word consisting of English lowercase letters, return the length of the longest beautiful substring of word.
 * If no such substring exists, return 0.
 * A substring is a contiguous sequence of characters in a string.
 * 
 */
public class LongestSubStringOfAllVowels {
    public static void main(String[] args) {
        LongestSubStringOfAllVowels sol = new LongestSubStringOfAllVowels();
        System.out.println(sol.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }
    public int longestBeautifulSubstring(String word) {
        int count = 1;
        int l = 1;
        int max_len = 0;

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                l++;
            } else if (word.charAt(i - 1) < word.charAt(i)) {
                count++;
                l++;
            } else {
                l = 1;
                count = 1;
            }
            if (count == 5) {
                max_len = Math.max(max_len, l);
            }
        }

        return max_len;
    }
}
