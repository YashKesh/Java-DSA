package Yashque;
import java.util.*;
public class SubarraySumK {
    public static void main(String[] args) {
        SubarraySumK sol = new SubarraySumK();
        System.out.print(sol.subarraySum(new int[]{1,1,1},2));
    }
        public int subarraySum(int[] nums, int k) {
            // int[] prefix = new int[nums.length];
            ArrayList<Integer> prefix = new ArrayList<>();
            int ans = 0;
            prefix.add(nums[0]);
            Map<Integer,Integer> newmap = new HashMap<>();
            newmap.put(0,1);
            for(int i = 1;i<nums.length;i++){
                prefix.add(nums[i]+prefix.get(prefix.size()-1));
            }
            for(int i = 0;i<prefix.size();i++){
                if(newmap.containsKey(prefix.get(i)-k)){
                    ans+=newmap.get(prefix.get(i)-k);
                }
                newmap.put(prefix.get(i),newmap.getOrDefault(prefix.get(i),0)+1);
            }
            return ans;
        }
    }

