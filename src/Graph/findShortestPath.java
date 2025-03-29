package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
/*
 * Given a grid of size n x m, 1 represents a path and 0 represents a blocked cell.
 * The task is to find the shortest path between a given source cell to a destination cell.
 * The path can only be created out of a cell if its value is 1.
 * Given a matrix mat[][] with r rows and c columns, where some cells are landmines (marked as 0) and others are safe to traverse.
 *  Your task is to find the shortest safe route from any cell in the leftmost column to any cell in the rightmost column of the mat.
 *  You cannot move diagonally, and you must avoid both the landmines and their adjacent cells (up, down, left, right),
 *  as they are also unsafe.
 */
class Pair {
    int row;
    int col;
    int distance;

    // Constructor with distance parameter
    public Pair(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }

    // Constructor without distance, default distance = 0
    public Pair(int row, int col) {
        this(row, col, 0);
    }
}
public class findShortestPath {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
            };
        System.out.println(new findShortestPath().findShortestPath(grid));
        
    }
      public int dfs(int row , int col , int[][] mat , boolean[][] visited  , int n , int m,
    int[] rows ,int[] cols
    ){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.distance - y.distance);
        int[][] dist = new int[n][m];
        for(int[] sub : dist){
            Arrays.fill(sub , (int)1e7);
        }
        dist[row][col] = 1;
        pq.add(new Pair(row , col, 1));
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int r = node.row;
            int c = node.col;
            int d = node.distance;
            if(visited[r][c])continue;
            if(c == m-1){
                return d;
            }
            visited[r][c] = true;
            for(int i = 0 ;i < 4;i++){
                int nr = r + rows[i];
                int nc = c + cols[i];
                if(nr >= 0 && nc >=0 && nr < n && nc < m && mat[nr][nc] == 1 && !visited[nr][nc]){
                    if(dist[nr][nc] > d + 1){
                        dist[nr][nc] = d + 1;
                        pq.add(new Pair(nr , nc  , dist[nr][nc]));
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    public int findShortestPathMyAprroach(int[][] mat) {
        // code here
        int n = mat.length;
        int m  = mat[0].length;
        int[] rows = new int[]{-1,0,1,0};
        int[] cols = new int[]{0,1,0,-1};
        for(int i = 0;i< n ;i++){
            for(int j = 0 ; j< m ;j++){
                if(mat[i][j] == 0){
                    int row = i ;
                    int col = j;
                    for(int k = 0 ;k < 4;k++){
                        int nr = row + rows[k];
                        int nc = col + cols[k];
                        if(nr >= 0 && nc >= 0 && nr < n && nc < m && mat[nr][nc] == 1){
                            mat[nr][nc] = -1;
                        }
                    }
                }
            }
        }
        
        boolean[][] visited;
        int shortest = Integer.MAX_VALUE;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i< n ;i++){
            if(mat[i][0] == 1){
                q.add(new Pair(i,0));
            }
        }
        while(!q.isEmpty()){
            Pair node = q.poll();
            int row = node.row;
            int col = node.col;
            visited = new boolean[n][m];
            int dist = dfs(row , col , mat, visited  , n , m,rows ,cols);
            shortest = Math.min(dist , shortest);
        }
        return (shortest == Integer.MAX_VALUE) ? -1 : shortest;
        
        
    }
    public int findShortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] rows = new int[] { -1, 0, 1, 0 };
        int[] cols = new int[] { 0, 1, 0, -1 };

        // Mark adjacent cells of mines as unsafe
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + rows[k];
                        int nj = j + cols[k];
                        if (ni >= 0 && nj >= 0 && ni < n && nj < m && mat[ni][nj] == 1) {
                            mat[ni][nj] = -1; // unsafe
                        }
                    }
                }
            }
        }

        // Convert -1 to 0 directly
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == -1)
                    mat[i][j] = 0;
            }
        }

        // Multi-source BFS
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        for (int[] d : dist)
            Arrays.fill(d, (int) 1e7);

        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 1) {
                q.add(new Pair(i, 0, 1)); // Start distance 0
                dist[i][0] = 0;
            }
        }

        while (!q.isEmpty()) {
            Pair node = q.poll();
            int r = node.row, c = node.col, d = node.distance;
            for (int i = 0; i < 4; i++) {
                int nr = r + rows[i];
                int nc = c + cols[i];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && mat[nr][nc] == 1 && dist[nr][nc] > d + 1) {
                    dist[nr][nc] = d + 1;
                    q.add(new Pair(nr, nc, d + 1));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dist[i][m - 1]);
        }
        return (ans == (int) 1e7) ? -1 : ans;
    }
}
