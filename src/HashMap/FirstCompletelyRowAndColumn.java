package HashMap;

import java.util.Arrays;
import java.util.HashMap;

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class FirstCompletelyRowAndColumn {
    public static void main(String[] args) {
        // Your code here
        int[] arr = new int[] { 1, 3, 4, 2 };
        int[][] mat = new int[][] {
                { 1, 4 }, { 2, 3 }
        };
        FirstCompletelyRowAndColumn sol = new FirstCompletelyRowAndColumn();
        System.out.println(sol.firstCompleteIndex(arr, mat));
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, Pair> map = new HashMap<>();
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j], new Pair(i, j));
            }
        }
        int[] rowcount = new int[n];
        int[] colcount = new int[m];
        for (int i = 0; i < arr.length; i++) {
            Pair node = map.get(arr[i]);
            rowcount[node.first]++;
            colcount[node.second]++;
            if (rowcount[node.first] == m || colcount[node.second] == n) {
                return i;
            }
        }
        return -1;

    }
}