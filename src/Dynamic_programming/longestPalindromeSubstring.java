package Dynamic_programming;
/*Given a string s, return the longest
palindromic substring in s.
Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"    */
public class longestPalindromeSubstring {
    public static void main(String[] args) {
        longestPalindromeSubstring sol = new longestPalindromeSubstring();
        System.out.println(sol.longestPalindrome("babad"));
    }
//    class Solution {
        public String longestPalindrome(String s) {
            for (int length = s.length(); length > 0; length--) {
                for (int start = 0; start <= s.length() - length; start++) {
                    if (check(start, start + length, s)) {
                        return s.substring(start, start + length);
                    }
                }
            }

            return "";
        }

        private boolean check(int i, int j, String s) {
            int left = i;
            int right = j - 1;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }
    }
//}
