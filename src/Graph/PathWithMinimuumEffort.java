package Graph;
import java.util.*;
/*
You are a hiker preparing for an upcoming hike. You are given heights[][], a 2D array of size rows x columns,
where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you
hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, '
and you wish to find the route with minimum effort.

Note: A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Example 1:

Input:
row = 3
columns = 3
heights = [[1,2,2],[3,8,2],[5,3,5]]
Output:
2
Explaination:
The route 1->3->5->3->5 has a maximum absolute difference of 2 in consecutive cells. This is better than the route
 1->2->2->2->5, where the maximum absolute difference is 3.
 */
class Tuple{
    int first;
    int second;
    int third;
    public Tuple(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
public class PathWithMinimuumEffort {
        public static int MinimumEffort(int rows, int columns, int[][] heights) {
            // code here
            PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.first - y.first);
            int[][] diff = new int[rows][columns];
            for(int[] sub: diff){
                Arrays.fill(sub,(int)1e7);
            }
            pq.add(new Tuple(0,0,0));
            diff[0][0] = 0;
            int[] rowcol = {-1,0,1,0};
            int[] colcol = {0,1,0,-1};
            while(!pq.isEmpty()){
                int maxdiff = pq.peek().first;
                int row = pq.peek().second;
                int col = pq.peek().third;
                if(row==rows-1 && col == columns-1){
                    return maxdiff;
                }
                pq.remove();
                for(int i = 0;i<4;i++){
                    int newr = row + rowcol[i];
                    int newc = col + colcol[i];
                    if(newr>=0 && newr<rows && newc>=0 && newc<columns
                    ){
                        int currenteff = Math.abs(heights[row][col] - heights[newr][newc]);
                        int maxeff = Math.max(currenteff,maxdiff);
                        if(maxeff<diff[newr][newc]){
                            diff[newr][newc] = maxeff;
                            pq.add(new Tuple(maxeff,newr,newc));
                        }

                    }

                }
            }
            return diff[rows-1][columns-1];

        }
    }

