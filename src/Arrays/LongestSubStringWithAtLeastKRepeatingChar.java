package Arrays;
/*
 * Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each 
 * character in this substring is greater than or equal to k.
 * 
 */

// Time Complexity: O(N^2)
// Space Complexity: O(N)
// N is the length of the string
// The above solution is a recursive solution where we are checking for each character if the frequency of the character is less than k
// if it is less than k then we are splitting the string into two parts and checking for the maximum length of the substring
// The above solution is not efficient as we are checking for each character and splitting the string into two parts
// We can solve this problem using a sliding window approach where we can keep track of the frequency of the characters in the window
// and if the frequency of the character is less than k then we can split the window into two parts and check for the maximum length of the substring

public class LongestSubStringWithAtLeastKRepeatingChar {
    public static void main(String[] args) {
        LongestSubStringWithAtLeastKRepeatingChar sol = new LongestSubStringWithAtLeastKRepeatingChar();
        System.out.println(sol.longestSubstring("aaabb", 3));
    }
    public int solve(char[] ch,int start ,int end , int k){
        if(end - start < k){
            return 0;
        }
        int[] count = new int[26];
        for(int i  = start;i<end;i++){
            count[ch[i] -'a']++;
        }
        for(int i = start; i<end ;i++){
            if(count[ch[i] - 'a'] < k){
                int j = i + 1;
                while(j<end && count[ch[j] - 'a'] < k){
                    j++;
                }
                return Math.max(solve(ch, start ,i,k), solve(ch, j,end,k));
            }
        }
        return end - start;
    }
    public int longestSubstring(String s, int k) {
           return solve(s.toCharArray(),0,s.length(),k);
    }   
}
