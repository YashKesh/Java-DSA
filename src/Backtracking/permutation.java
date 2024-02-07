package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class permutation {
    public static void solve(int[] nums,List<List<Integer>> ans,int index){
        if(index>=nums.length){
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            ans.add(permutation);
            return;
        }
        for(int j = index;j<nums.length;j++){
            int temp = nums[index];
            nums[index] = nums[j];
            nums[j] = temp;
            solve(nums,ans,index+1);
            temp = nums[j];
            nums[j] = nums[index];
            nums[index] = temp;
        }
    }
    public static void solve(int[] nums,List<List<Integer>> ans,boolean[] map,List<Integer> list1){
        if(list1.size()==nums.length){
            ans.add(new ArrayList<>(list1));
        }
        for(int i = 0;i<nums.length;i++){
            if(!map[i]){
                map[i]=true;
                list1.add(nums[i]);
                solve(nums,ans,map,list1);
                list1.remove(list1.size()-1);
                map[i] = false;
            }
        }

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> ans1 = new ArrayList<>();
        int index = 0;
        boolean[] map = new boolean[nums.length] ;
        solve(nums,ans,map,new ArrayList<>());
        solve(nums,ans1,0);
        return ans;


    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1, 2, 3};
        List<List<Integer>> ans = permute(nums);
        System.out.print(ans);


    }
}
