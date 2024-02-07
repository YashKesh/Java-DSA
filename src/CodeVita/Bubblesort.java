package CodeVita;
import java.util.Scanner;

public class Bubblesort {

    static int countDesc = 0;
    static int countAsc = 0;

    static void sortAscending(int[] array, int size) {
        for (int step = 0; step < size - 1; ++step) {
            for (int i = 0; i < size - step - 1; ++i) {
                if (array[i] < array[i + 1]) {
                    // Swap elements
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    countDesc++;
                }
            }
        }
    }

    static void sortDescending(int[] array, int size) {
        for (int step = 0; step < size - 1; ++step) {
            for (int i = 0; i < size - step - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    // Swap elements
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    countAsc++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size
        int size = scanner.nextInt();

        // Input array
        int[] data = new int[size];
        int[] data1 = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = scanner.nextInt();
            data1[i] = data[i];
        }

        // Sort arrays and count swaps
        sortDescending(data, size);
        sortAscending(data1, size);

        // Output the minimum swaps
        if (countAsc > countDesc) {
            System.out.println(countDesc);
        } else {
            System.out.println(countAsc);
        }
    }
}
