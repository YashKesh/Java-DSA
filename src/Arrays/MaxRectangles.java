package Arrays;
import java.util.Arrays;
public class MaxRectangles {
    // int[] arr = { 2, 6, 6, 2, 3, 5 }; // 12
    // int[] arr = { 4, 3, 2, 3, 4, 5, 2, 4 };// 22
    // int [] arr = {2,1,6,5,4,4};// 20
    // int [] arr = {2,3,3,4,6,6,8,8};// 54
    // int [] arr = {10, 10, 10, 10, 11, 10, 11, 10};// 210
    // int [] arr = {3, 4, 5, 6};// 15
    // int [] arr = {3, 2, 5, 2};// 0
    // int[] arr =int[] arr = { 11, 11, 10, 10, 10, 10, 10, 11, 10, 30, 10, 9, 9, 8,
    // 8, 7, 6, 5, 10, 12, 12 };// 439

    // WITHOUT MAP
    public static int maxArea(int[] arr) {
        int n = arr.length, totalArea = 0;
        Arrays.sort(arr);
        int length = -1, breadth = -1, pair = 0;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] == arr[i - 1] || arr[i - 1] + 1 == arr[i]) {
                if (pair == 1) {
                    breadth = arr[i - 1];
                    pair++;
                } else if (pair == 0) {
                    length = arr[i - 1];
                    pair++;
                }
                i--;
            }
            if (pair == 2) {
                totalArea += (length * breadth);
                pair = 0;
            }
        }
        return totalArea;
    }
}
