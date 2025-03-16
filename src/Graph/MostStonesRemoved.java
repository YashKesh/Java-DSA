package Graph;

import java.util.*;
/*
 * On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.

Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest 
possible number of stones that can be removed.

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Explanation: One way to remove 5 stones is as follows:
1. Remove stone [2,2] because it shares the same row as [2,1].
2. Remove stone [2,1] because it shares the same column as [0,1].
3. Remove stone [1,2] because it shares the same row as [1,0].
4. Remove stone [1,0] because it shares the same column as [0,0].
5. Remove stone [0,1] because it shares the same row as [0,0].
Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
 */

public class MostStonesRemoved {
    int maxRemove(int[][] stones,int n){
        int maxrow = 0;
        int maxcol = 0;
        for(int i = 0;i<n;i++){
            maxrow = Math.max(maxrow,stones[i][0]);
            maxcol = Math.max(maxcol,stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxrow + maxcol + 1);
        HashMap<Integer,Integer> set = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            int col = stones[i][1] + maxrow + 1;
            ds.unionBySize(row,col);
            set.put(row,1);
            set.put(col,1);
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> entry : set.entrySet()){
            if(ds.findParent(entry.getKey()) == entry.getKey()){
                count++;
            }
        }
        return  n-count;
    }
}
