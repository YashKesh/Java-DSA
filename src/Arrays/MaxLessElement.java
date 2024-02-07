package Arrays;
import java.util.*;
public class MaxLessElement {
    public static void main(String[] args) {
//        MaxLessElement sol = new MaxLessElement();
        System.out.println(Arrays.toString(ninjaAndLessMaxElement(3, new int[]{1, 2, 1})));
    }
        static int[] ninjaAndLessMaxElement(int n, int[] a) {
            // Write your code here.
            int[] result = new int[n];
            Arrays.fill(result, 0);
            int last_index = -1;
            result[0] = -1;

            for (int i = 1; i < n; i++) {
                int current_element = a[i];
                int max_less_element = Integer.MIN_VALUE;
                int j = i - 1;

                while (j >= 0) {
                    if (a[j] == current_element) {
                        break;
                    }
                    if (a[j] < current_element) {
                        if (a[j] > max_less_element) {
                            max_less_element = a[j];
                        }
                    }
                    j--;
                }

                if (max_less_element != Integer.MIN_VALUE) {
                    last_index = i;
                    result[i] = max_less_element;
                } else {
                    result[i] = -1;
                }
            }

            return result;
        }
    }

