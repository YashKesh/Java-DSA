package Graph;

import java.util.*;

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
                count++;;
            }
        }
        return  n-count;
    }
}
