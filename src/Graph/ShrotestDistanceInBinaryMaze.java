package Graph;

import java.util.*;
import java.lang.*;
import java.io.*;
/*
Given a n * m matrix grid where each element can either be 0 or 1. You need to find the shortest distance between a
given source cell to a destination cell. The path can only be created out of a cell if its value is 1.

If the path is not possible between source cell and destination cell, then return -1.

Note : You can move into an adjacent cell if that adjacent cell is filled with element 1. Two cells are adjacent if they
share a side. In other words, you can move in one of the four directions, Up, Down, Left and Right.
The source and destination cell are based on the zero based indexing. The destination cell should be 1.

Example 1:

Input:
grid[][] = {{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}}
source = {0, 1}
destination = {2, 2}
Output:
3
Explanation:
1 1 1 1
1 1 0 1
1 1 1 1
1 1 0 0
1 0 0 1
The highlighted part in the matrix denotes the
shortest path from source to destination cell.
 */
class Triple{
    int first;
    int second;
    int third;
    public Triple(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
public class ShrotestDistanceInBinaryMaze {
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while (T-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int[][] grid = new int[n][m];

                for (int i = 0; i < n; i++) {

                    for (int j = 0; j < m; j++) {
                        grid[i][j] = sc.nextInt();
                    }
                }
                int[] source = new int[2];
                for (int i = 0; i < 2; i++) {
                    int x = sc.nextInt();
                    source[i] = x;
                }
                int[] dest = new int[2];
                for (int i = 0; i < 2; i++) {
                    int x = sc.nextInt();
                    dest[i] = x;
                }
                ShrotestDistanceInBinaryMaze ob = new ShrotestDistanceInBinaryMaze();
                int ans = ob.shortestPath(grid, source, dest);
                System.out.println(ans);
            }
        }
    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        Queue<Triple> q = new LinkedList<>();
        q.add(new Triple(0,source[0],source[1]));
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int[] sub : dist){
            Arrays.fill(sub,(int)1e7);
        }
        dist[source[0]][source[1]] = 0;
        int[] rowcol = {-1,0,1,0};
        int[] colcol = {0,-1,0,1};
        if(source[0] == destination[0] && source[1]==destination[1]){
            return 0;
        }
        while(!q.isEmpty()){
            int dis = q.peek().first;
            int  row = q.peek().second;
            int col = q.peek().third;
            q.poll();
            for(int i = 0;i<4;i++){
                int newr = row  + rowcol[i];
                int newcol = col + colcol[i];
                if(newr<n && newr>=0 && newcol<m && newcol>=0 && grid[newr][newcol]==1 && dis + 1 < dist[newr][newcol]
                ){
                    dist[newr][newcol] = dis + 1;
                    if(newr == destination[0] && newcol==destination[1]){
                        return dis + 1;
                    }
                    q.add(new Triple(dis+1,newr,newcol));
                }
            }

        }
        return -1;
    }
}






