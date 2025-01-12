package Arrays;
/*
 * Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, 
 * compute how much water can be trapped between the blocks during the rainy season. 
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater sol = new TrappingRainWater();
        System.out.println(sol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public int trap(int[] arr) {
        
        int n = arr.length;
        int[] maxleft = new int[n];
        int[] maxright = new int[n];
        maxleft[0] = arr[0];
        maxright[n-1] = arr[n-1];
        for(int i = 1;i<n;i++){
            maxleft[i] = Math.max(maxleft[i-1] , arr[i]);
            maxright[n-i-1] = Math.max(maxright[n-i],arr[n-i-1]);
        }
        int water = 0;
        for(int i = 0;i<n;i++){
            int level = Math.min(maxleft[i],maxright[i]);
            water+=level-arr[i];;
        }
        return water;
    }
}
