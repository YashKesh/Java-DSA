package Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
/*
 * 
 */
class Pair{
    int i;
    int j;
    int weight;
    public Pair(int i ,int j,int weight){
        this.i = i;
        this.j = j;
        this.weight = weight;
    }
}
public class MinCostToMakeAValidPath {
    
     public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[]{0,0,1,-1};
        int[] col = new int[]{1,-1,0,0};
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.weight - y.weight);
        pq.add(new Pair(0,0,0));
        int[][] dist = new int[m][n];
        for(int[] sub : dist){
            Arrays.fill(sub ,(int)1e7);
        }
        dist[0][0] = 0;
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int i = pair.i;
            int j = pair.j;
            int weight = pair.weight;
            for(int k = 0;k<4;k++){
                int newrow = i + row[k];
                int newcol = j + col[k];
                int adjwt = grid[i][j] - 1 == k ? 0 : 1;
                if(newrow >=0 && newcol >=0 && newrow<m && newcol<n){
                    if(adjwt + weight < dist[newrow][newcol]){
                        dist[newrow][newcol] = adjwt + weight;
                        pq.add(new Pair(newrow,newcol,dist[newrow][newcol]));
                    }
                } 
            }
        }
        return dist[m-1][n-1];
    }
    public int Myapproach(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[]{0, 0, 1, -1};
        int[] col = new int[]{1, -1, 0, 0};
        
        ArrayList<Pair>[][] adj = new ArrayList[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                adj[i][j] = new ArrayList<>();
                
                for(int k = 0; k < 4; k++) {
                    int newrow = i + row[k];
                    int newcol = j + col[k];
                    
                    if(newrow >= 0 && newrow < m && newcol >= 0 && newcol < n) {
                        if(grid[i][j] - 1 == k) {
                            adj[i][j].add(new Pair(newrow, newcol, 0));
                        } else {
                            adj[i][j].add(new Pair(newrow, newcol, 1));
                        }
                    }
                }
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Pair(0, 0, 0));
        int[][] dist = new int[m][n];
        for(int[] row1 : dist) {
            Arrays.fill(row1, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int i = curr.i;
            int j = curr.j;
            int weight = curr.weight;            
            if(weight > dist[i][j]) continue;
            
            for(Pair next : adj[i][j]) {
                int ni = next.i;
                int nj = next.j;
                int newWeight = weight + next.weight;
                
                if(newWeight < dist[ni][nj]) {
                    dist[ni][nj] = newWeight;
                    pq.add(new Pair(ni, nj, newWeight));
                }
            }
        }
        
        return dist[m-1][n-1];
    }
}
