package Arrays;

public class SumAbsoluteDifferences {
    public static void main(String[] args) {
        SumAbsoluteDifferences sol = new SumAbsoluteDifferences();
        System.out.println(sol.getSumAbsoluteDifferences(new int[]{2,3,5}));
    }
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int left = 0;
        int right = sum;

        int[] r = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            right -= n;

            r[i] = n * i - left + right - n * (nums.length - i - 1);

            left += n;
        }

        return r;
    }
}
