package CodeVita;
import java.util.*;
class Structure {
    int expenditure;
    int bonus;
    int reward_penalty;
}
public class PerfectBudget {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int n = scanner.nextInt();
            Structure[] projects = new Structure[n];

            for (int i = 0; i < n; i++) {
                projects[i] = new Structure();
                projects[i].expenditure = scanner.nextInt();
                projects[i].bonus = scanner.nextInt();
                projects[i].reward_penalty = scanner.nextInt();
            }

            int result = minPerfectBudget(projects, n);
            System.out.println(result);

        }

        private static int minPerfectBudget(Structure[] projects, int n) {
            int minBudget = 10001;

            for (int i = 0; i < n; i++) {
                minBudget = Math.min(minBudget, projects[i].expenditure + projects[i].reward_penalty);
            }

            for (int budget = minBudget; budget <= 10000; budget++) {
                if (isPossible(projects, n, budget)) {
                    return budget;
                }
            }

            return -1; //
        }

        private static boolean isPossible(Structure[] projects, int n, int budget) {
            int currentBudget = budget;

            for (int i = 0; i < n; i++) {
                int expenditure = projects[i].expenditure;
                int bonus = projects[i].bonus;
                int reward_penalty = projects[i].reward_penalty;

                if (currentBudget < expenditure) {
                    return false;
                }

                currentBudget += reward_penalty;
                currentBudget -= expenditure;
                currentBudget += bonus;

                if (currentBudget < 0) {
                    return false;
                }
            }

            return true;
        }
    }


