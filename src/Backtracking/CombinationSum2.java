package Backtracking;
//import  jav

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2 sol = new CombinationSum2();
        System.out.println(sol.combinationSum2(new int[]{2,2,1,5,3,6,8},12));
    }
        public void check(List<List<Integer>> res , int[] candidates, int target, int sum1, int start, List<Integer> list1){
        if(sum1 == target){
            res.add(new ArrayList<>(list1));
            return;
        }
        else if(sum1>target){
            return;
        }
            for(int i = start;i<candidates.length;i++){
                if(i>start && candidates[i]==candidates[i-1]){
                    continue;
                }
                else{
                    sum1+=candidates[i];
                    list1.add(candidates[i]);
                    check(res,candidates,target,sum1,i+1,list1);
                    sum1-=candidates[i];
                    list1.remove(list1.size()-1);}
            }
        }
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            int start = 0,sum1= 0;
            Arrays.sort(candidates);
            List<Integer> list1 = new ArrayList<>();
            check(res,candidates,target,0,0,list1);
            return res;


        }

}
