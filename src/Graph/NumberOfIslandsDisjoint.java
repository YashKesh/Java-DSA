package Graph;
import  java.util.*;
/*
 * Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
 * A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.
 * Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.
 */
public class NumberOfIslandsDisjoint {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        DisjointSet ds = new DisjointSet(rows * cols);
        List<Integer> ans = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];
        int cnt = 0;
        for(int i = 0;i<operators.length;i++){
            int row = operators[i][0];
            int col = operators[i][1];
            if(visited[row][col]){
                ans.add(cnt);
                continue;
            }
            visited[row][col] = true;
            cnt++;
            int[] rowcol = {-1,0,1,0};
            int[] colcol = {0,1,0,-1};
            for(int j = 0;j<4;j++){
                int adjr  = rowcol[j] + row;
                int adjc = colcol[j] + col;
                if(adjr<rows && adjr>=0 && adjc<cols && adjc>=0){
                    if(visited[adjr][adjc]){
                        int node = row * cols + col;
                        int adjnode = cols * adjr + adjc;
                        if(ds.findParent(node)!=ds.findParent(adjnode)){
                            cnt--;
                            ds.unionBySize(node,adjnode);
                        }

                    }
                }
            }
            ans.add(cnt);
        }
        return ans;

    }
}
