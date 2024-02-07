package CodeVita;

import java.util.Scanner;

public class WinnerFinder {

    static boolean isValidRow(String row) {
        int len = row.length();
        if (len < 3) {
            return false;
        }

        for (int i = 1; i < len - 1; i++) {
            if (row.charAt(i) == row.charAt(i - 1) || row.charAt(i) == row.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    static int countPossibilities(String row) {
        int len = row.length();
        if (!isValidRow(row)) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 2; j < len; j++) {
                for (int k = i + 1; k < j; k++) {
                    if (row.charAt(i) != row.charAt(j) && row.charAt(i) != row.charAt(k) && row.charAt(j) != row.charAt(k)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    static String findWinner(String ashokRow, String anandRow) {
        if (!isValidRow(ashokRow) || !isValidRow(anandRow)) {
            return "Invalid input";
        }

        int ashokPossibilities = countPossibilities(ashokRow);
        int anandPossibilities = countPossibilities(anandRow);

        if (ashokPossibilities > anandPossibilities) {
            return "Ashok";
        } else if (anandPossibilities > ashokPossibilities) {
            return "Anand";
        } else {
            return "Draw";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Ashok's row: ");
        String ashokRow = scanner.next();

        System.out.print("Enter Anand's row: ");
        String anandRow = scanner.next();

        String winner = findWinner(ashokRow, anandRow);
        System.out.println("Winner: " + winner);
    }
}
