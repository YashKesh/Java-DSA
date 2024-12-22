package CodeForces;
import java.util.*;


public class Main {
    public static long solve(int n, int a, int b, int c) {
        long sum = a + b + c;
        List<Integer> v = Arrays.asList(a, b, c);
        long days = (n / sum) * 3;
        long left = n % sum;
        int i = 0;

        while (left > 0) {
            left -= v.get(i % 3);
            i++;
            days++;
        }

        return days;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        while (x-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            System.out.println(solve(n, a, b, c));
        }

        sc.close();
    }
}
