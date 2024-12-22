package Graph;
import java.util.*;
public class FindShortestCycle {
    public static void main(String[] args) {
        FindShortestCycle sol = new FindShortestCycle();
        System.out.println(sol.findShortestCycle(8,new int[][]{
                {1, 3},
                {3, 5},
                {5, 7},
                {7, 1},
                {0, 2},
                {2, 4},
                {4, 0},
                {6, 0},
                {6, 1}
        }));
    }
    public int cyclelength = Integer.MAX_VALUE;
    public int dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] visited,int length){
        System.out.println(length + " " + node);

        visited[node] = true;
        for(int edg :adj.get(node)){
            if(!visited[edg]){
                if(dfs(edg,node,adj,visited,length+1)!=-1){
                    return cyclelength;}
            }else if(edg!=parent){
                cyclelength = Math.min(cyclelength,length+1);
                return cyclelength;
            }
        }
         return -1;
    }
    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                int length = 1;
                dfs(i,-1,adj,visited,length);
            }
        }
        System.out.print(adj);
        if(cyclelength==Integer.MAX_VALUE){
            return -1;
        }
        return cyclelength;
    }


    public int findShortestCycleLength(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        int minCycle = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            Arrays.fill(dist, -1);
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            dist[i] = 0;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : adj[u]) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        q.offer(v);
                    } else if (v != i && dist[v] >= dist[u]) {
                        minCycle = Math.min(minCycle, dist[u] + dist[v] + 1);
                    }
                }
            }
        }

        if (minCycle == Integer.MAX_VALUE)
            return -1;

        return minCycle;
    }

}
