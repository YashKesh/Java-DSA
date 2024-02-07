package Arrays;
import java.util.*;
public class sum3set {
    public static void main(String[] args) {
        sum3set sol = new sum3set();
        System.out.print(sol.threeSum(new int[]{-2,2,1,2,4,5,1,-1,2,1,0,1,-5,6,-7}));
    }
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int target  = 0;
            Set<List<Integer>> set = new HashSet<>();
            for(int i = 0;i<nums.length;i++){
                int j = i+1;
                int k = nums.length-1;
                while(j<k){
                    int sum1  = nums[i]+nums[j]+nums[k];
                    if(sum1 == target){
                        set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        k = k-1;
                        j = j+1;
                    }
                    else if(sum1<0){
                        j = j+1;
                    }
                    else{
                        k = k-1;
                    }
                }
            }
            List<List<Integer>> res = new ArrayList<>(set);
            return res;
        }

}
