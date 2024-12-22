package CodeForces;
import java.util.*;

public class Trek {
    public static int solve(List<Integer> m, List<Integer> s) {
        long mono = 0, sterio = 0;
        int n = m.size();

        for (int i = 0; i < n; i++) {
            if (i + 1 < n && m.get(i) > m.get(i + 1)) {
                mono += m.get(i);
                sterio += s.get(i + 1);
            }
        }

        mono += m.get(n - 1);
        return (int)(mono - sterio);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            int x = sc.nextInt();
            List<Integer> m = new ArrayList<>();
            List<Integer> s = new ArrayList<>();

            for (int i = 0; i < x; i++) {
                m.add(sc.nextInt());
            }

            for (int i = 0; i < x; i++) {
                s.add(sc.nextInt());
            }

            System.out.println(solve(m, s));
        }

        sc.close();
    }
}
