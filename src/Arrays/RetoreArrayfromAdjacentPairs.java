/*There is an integer array nums that consists of n unique elements, but you have forgotten it.
However, you do remember every pair of adjacent elements in nums.
You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi]
indicates that the elements ui and vi are adjacent in nums.
It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs,
either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
Return the original array nums. If there are multiple solutions, return any of them.*/
package Arrays;
import java.util.*;
public class RetoreArrayfromAdjacentPairs {
    public static void main(String[] args) {
        RetoreArrayfromAdjacentPairs sol = new RetoreArrayfromAdjacentPairs();
        int[][] adjacentPairs = {
                {-3, -9},
                {-5, 3},
                {2, -9},
                {6, -3},
                {6, 1},
                {5, 3},
                {8, 5},
                {-5, 1},
                {7, 2}
        };
        System.out.println(sol.restoreArray(adjacentPairs));
    }
//    class Solution {
        public void solve(int[] ans,int root,int prev,Map<Integer,ArrayList<Integer>> map,int i){
            ans[i] = root;
            for(int neighbour : map.get(root)){
                if(neighbour!=prev){
                    solve(ans,neighbour,root,map,i+1);
                }
            }
        }
        public int[] restoreArray(int[][] adjacentPairs) {
            Map<Integer,ArrayList<Integer>> map = new HashMap<>();
            for(int i = 0;i<adjacentPairs.length;i++){
                if(!map.containsKey(adjacentPairs[i][0])){
                    map.put(adjacentPairs[i][0],new ArrayList<>());
                    // map.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
                }
                if(!map.containsKey(adjacentPairs[i][1])){
                    map.put(adjacentPairs[i][1],new ArrayList<>());
                    // map.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
                }

                map.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
                map.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);

            }
            int root  = 0;
            for(int key : map.keySet()){
                if(map.get(key).size()==1){
                    root = key;
                    break;
                }
            }
            int[] ans = new int[map.size()];
            solve(ans,root,Integer.MAX_VALUE,map,0);
            return ans;
        }
    }
//}
