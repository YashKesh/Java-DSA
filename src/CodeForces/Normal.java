package CodeForces;

import java.util.Scanner;

public class Normal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            
            // Call the solve function to get the result for this test case
            System.out.println(solve(a, b, n, 0, true, 0, 0));  // Pass initial parameters
        }
        
        sc.close();
    }

    public static int solve(int[] a, int[] b, int n, int index, boolean turn, int monosum, int stereo) {
        if (index >= n) {
            // Return the difference when all days are processed
            return monosum - stereo;
        }

        int result = Integer.MIN_VALUE;

        if (turn) {
            // Monocarp's turn
            // Monocarp trains on this day
            result = Math.max(result, solve(a, b, n, index + 1, false, monosum + a[index], stereo));
            // Monocarp skips this day
            result = Math.max(result, solve(a, b, n, index + 1, turn, monosum, stereo));
        } else {
            // Stereocarp's turn (Monocarp skips this day)
            result = Math.max(result, solve(a, b, n, index + 1, true, monosum, stereo + b[index])) ;
        }

        return result;  // Return the maximum difference found
    }
}
