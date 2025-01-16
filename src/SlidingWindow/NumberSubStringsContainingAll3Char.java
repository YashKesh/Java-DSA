package SlidingWindow;
/*
 * Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", 
"abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1

 */
public class NumberSubStringsContainingAll3Char {
    public static void main(String[] args) {
        String str = "abcabc";
        NumberSubStringsContainingAll3Char sol = new NumberSubStringsContainingAll3Char();
        System.out.println(sol.numberOfSubstrings(str));
    }

    public int numberOfSubstrings(String s) {
        int count = 0;
        int n = s.length();
        int[] lastseen = new int[]{-1,-1,-1};
        for(int i = 0;i<n;i++){
            lastseen[s.charAt(i) - 'a'] = i;
            if(lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1){
                count = count + 1 + Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2]));
            }
        }
        return count;
    }
}
