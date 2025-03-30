package Backtracking;
//import  jav

import java.util.*;
/*
 * Given a number N. Find all the unique combinations in candidates where the candidate numbers sum to T.
 * For example, given candidate set 2,3,6,7 and target 7, A solution set is [7], [2, 2, 3] and [3, 4].
 * For example, given candidate set 2,3,5 and target 8, A solution set is [2, 2, 2, 2], [2, 3, 3] and [3, 5].
 * For example, given candidate set 2,2,1,5,3,6,8 and target 12, A solution set is [2, 2, 3, 5], [2, 2, 8], [2, 3, 6], [2, 6, 3], [2, 5, 5], [3, 3, 6], [3, 5, 3], [5, 5, 2], [6, 6], [8, 2, 2].
 */

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
            check(res,candidates,target, sum1 ,start,list1);
            return res;


        }

}
