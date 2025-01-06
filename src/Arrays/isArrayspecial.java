package Arrays;


import java.util.Arrays;
/*
 * An array is considered special if every pair of its adjacent elements contains two numbers with different parity.

You are given an array of integer nums and a 2D integer matrix queries, where for queries[i] = [fromi, toi] your task is to check that 
subarray nums[fromi..toi] is special or not.

Return an array of booleans answer such that answer[i] is true if nums[fromi..toi] is special.
 */
public class isArrayspecial {
    public static void main(String[] args) {
        isArrayspecial sol = new isArrayspecial();
        System.out.println(Arrays.toString(sol.isArraySpecial(new int[]{4, 3, 1, 6}, new int[][]{{0, 2}, {2, 3}})));
    }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] ans = new boolean[queries.length];
        int[] same = new int[n];
        for (int i = 1; i < n; i++) {
            if ((nums[i] % 2) == (nums[i - 1] % 2)) {
                same[i] = 1;
            } else {
                same[i] = 0;
            }
        }
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + same[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if (prefixSum[end + 1] - prefixSum[start + 1] > 0) {
                ans[i] = false;
            } else {
                ans[i] = true;
            }
        }

        return ans;
    }
}
