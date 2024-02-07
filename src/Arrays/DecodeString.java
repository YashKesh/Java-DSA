package Arrays;
import java.util.*;
/*
You are given an encoded string s. To decode the string to a tape,
the encoded string is read one character at a time and the following steps are taken:
If the character read is a letter, that letter is written onto the tape.
If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.
Given an integer k, return the kth letter (1-indexed) in the decoded string.


 */
public class DecodeString {
    public static void main(String[] args) {
        DecodeString sol = new DecodeString();
//        System.out.println(sol.decodeAtIndex1("leet2code3",10));
        System.out.println(sol.decodeAtIndex3("leet2code3",10));
    }
    public String decodeAtIndex1(String s, int k) {
        long dlength = 0;
        for(char mychar : s.toCharArray()){
            if(Character.isDigit(mychar)){
                dlength*=(mychar - '0');
            }
            else{
                dlength++;
            }
        }
        for(int j = s.length()-1;j>=0;j--){
            char fin = s.charAt(j);
            if(Character.isDigit(fin)){
                dlength/=(fin - '0');
                k %= dlength;
            }
            else{
                if(k==0 || dlength == k){
                    return String.valueOf(fin);
                }
                dlength--;
            }

        }
        return "";
    }
    public String decodeAtIndex3(String encodedString, int k) {
        Stack<Long> characterLengths = new Stack<>(); // Stores the lengths of characters in the decoded string

        // Calculate lengths for each character in the encoded string
        characterLengths.push(0L); // Start with 0 length

        for (int i = 0; i < encodedString.length(); i++) {
            char c = encodedString.charAt(i);
            if (Character.isDigit(c)) {
                // If the character is a digit, update the length based on the digit
                long length = characterLengths.peek() * (c - '0');
                characterLengths.push(length);
            } else {
                // If the character is a letter, increment the length
                long length = characterLengths.peek() + 1;
                characterLengths.push(length);
            }
        }

        // Traverse the character lengths to decode and find the kth character
        int ln = characterLengths.size();
        while (!characterLengths.isEmpty()) {
            k %= characterLengths.peek(); // Adjust k based on the character length
            ln--;
            // If k is 0 and the character is an alphabet letter, return it
            if (k == 0 && Character.isLetter(encodedString.charAt(ln - 1))) {
                return String.valueOf(encodedString.charAt(ln - 1));
            }

            // Move to the previous character length
            characterLengths.pop();
        }

        return ""; // Return an empty string if no character is found
    }
//    public class Solution {
        public String decodeAtIndex(String inputString, int k) {
            long decodedLength = 0; // Total length of the decoded string

            for (char character : inputString.toCharArray()) {
                if (Character.isDigit(character)) {
                    // If the character is a digit, update the decoded length accordingly
                    decodedLength *= (character - '0');
                } else {
                    // If the character is a letter, increment the decoded length
                    decodedLength++;
                }
            }

            // Traverse the input string in reverse to decode and find the kth character
            for (int i = inputString.length() - 1; i >= 0; i--) {
                char currentChar = inputString.charAt(i);

                if (Character.isDigit(currentChar)) {
                    // If the character is a digit, adjust the length and k accordingly
                    decodedLength /= (currentChar - '0');
                    k %= decodedLength;
                } else {
                    // If the character is a letter, check if it's the kth character
                    if (k == 0 || decodedLength == k) {
                        return String.valueOf(currentChar); // Return the kth character as a string
                    }
                    decodedLength--;
                }
            }

            return ""; // Return an empty string if no character is found
        }
//    }
}
