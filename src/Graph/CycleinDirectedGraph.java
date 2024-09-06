package Graph;
import java.util.*;
/*
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not.
Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.
 */
public class CycleinDirectedGraph {
    public static void main(String[] args) {
        int[][] edges;
        edges = new int[][]{{1,2},{4,1},{2,4},{3,4},{5,2},{1,3}};
        System.out.println(detectCycleInDirectedGraph(6,edges));
    }
    public static boolean dfs(int node, ArrayList < ArrayList < Integer >> adj,int[] visited,int[] pathvisit){
        visited[node] = 1;
        pathvisit[node] = 1;
        for(int edg : adj.get(node)){
            if(visited[edg]==0){
                if(dfs(edg, adj, visited, pathvisit)==true){
                    return true;
                }
            }else if(pathvisit[edg]==1){
                return true;
            }
        }
        pathvisit[node] = 0;
        return false;
    }
    public static boolean detectCycleInDirectedGraph(int n, int[][] edges) {
        // Write your code here.
        ArrayList < ArrayList < Integer >> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        int[] visited = new int[n+1];
        int[] pathvisit = new int[n+1];
        for(int i = 0;i<edges.length;i++){
            int u  = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }
        for(int i  = 1;i<=n;i++){
            if(visited[i]==0){
                if(dfs(i,adj,visited,pathvisit)==true){
                    return true;
                }
            }
        }
        return false;
    }
}
