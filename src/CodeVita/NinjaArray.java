package CodeVita;

import java.util.Scanner;

public class NinjaArray {

    static int isPossible(int N, int X, int Y) {
        if ((X & Y) != Y) {
            return 0;
        }

        int countSetBits = 0;
        int tempY = Y;
        while (tempY > 0) {
            countSetBits += tempY & 1;
            tempY >>= 1;
        }

        if (countSetBits > N) {
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        // Example usage
        int result = isPossible(6, 3, 0);
        System.out.println(result);
    }
}
