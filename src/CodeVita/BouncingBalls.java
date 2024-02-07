package CodeVita;
import java.util.Scanner;

public class BouncingBalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[] p1 = new int[2];
        int[] d1 = new int[2];
        int[] p2 = new int[2];
        int[] d2 = new int[2];

        for (int i = 0; i < 2; i++) {
            p1[i] = scanner.nextInt();
        }
        for (int i = 0; i < 2; i++) {
            d1[i] = scanner.nextInt();
        }
        for (int i = 0; i < 2; i++) {
            p2[i] = scanner.nextInt();
        }
        for (int i = 0; i < 2; i++) {
            d2[i] = scanner.nextInt();
        }

        int steps = findOverlap(m, n, p1, d1, p2, d2);

        if (steps == Integer.MAX_VALUE) {
            System.out.println("Never");
        } else {
            System.out.println(steps + 1);
        }
    }

    private static int findOverlap(int m, int n, int[] p1, int[] d1, int[] p2, int[] d2) {
        int steps = 0;
        int maxSteps = 1000000; // Set a maximum limit to avoid infinite loop

        while (steps < maxSteps) {
            int[] n1 = {p1[0] + d1[0], p1[1] + d1[1]};

            if (n1[0] < 0 || n1[0] >= m || n1[1] < 0 || n1[1] >= n) {
                d1[0] = -d1[0];
                d1[1] = -d1[1];
            }

            p1 = n1;

            int[] n2 = {p2[0] + d2[0], p2[1] + d2[1]};

            if (n2[0] < 0 || n2[0] >= m || n2[1] < 0 || n2[1] >= n) {
                d2[0] = -d2[0];
                d2[1] = -d2[1];
            }

            p2 = n2;

            if (p1[0] == p2[0] && p1[1] == p2[1]) {
                return steps;
            }

            steps++;
        }

        return Integer.MAX_VALUE; // "Never"
    }
}
