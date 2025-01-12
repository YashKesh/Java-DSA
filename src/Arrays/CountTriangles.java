package Arrays;
import java.util.Arrays;
public class CountTriangles {
    public static void main(String[] args) {
        int[] arr = {10, 21, 22, 100, 101, 200, 300};
        System.out.println(countTriangles(arr));
    }
    static int countTriangles(int arr[]) {
        // code here
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0;i<arr.length-1;i++){
            int j = i+1;
            int k = arr.length-1;
            while(j<k){
                if(arr[i] + arr[j] > arr[k]){
                    count+=(k-j);
                    k--;
                }else{
                    j++;
                }
            }
        }
        return count;
    }
}
