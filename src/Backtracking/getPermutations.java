package Backtracking;
import java.util.*;
/*
 * Given a number N. Find all the unique combinations in candidates where the candidate numbers sum to T.
 * For example, given candidate set 2,3,6,7 and target 7, A solution set is [7], [2, 2, 3] and [3, 4].
 * For example, given candidate set 2,3,5 and target 8, A solution set is [2, 2, 2, 2], [2, 3, 3] and [3, 5].
 */

public class getPermutations {
    static void swap(char[] s, int i, int j) {
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }
    static void permutationHelper(char[] s, int index, ArrayList < String > res) {
        if (index == s.length) {
            String str = new String(s);

            res.add(str);
            return;
        }
        for (int i = index; i < s.length; i++) {
            swap(s, i, index);
            permutationHelper(s, index + 1, res);
            swap(s, i, index);
        }
    }

    static String getPermutation(int n, int k) {
        String s = "";
        ArrayList < String > res = new ArrayList < > ();
        for (int i = 1; i <= n; i++) {
            s += i;
        }
        permutationHelper(s.toCharArray(), 0, res);
        Collections.sort(res);

        return res.get(k);

    }
    public static void main(String[] args) {
        int n = 3, k = 3;
        String ans = getPermutation(n, k);
        System.out.println("The Kth permutation sequence is " + ans);
    }
}


