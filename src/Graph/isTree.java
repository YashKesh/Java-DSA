package Graph;
import java.util.*;
/*
 * A tree is a connected graph with no cycles
 * A tree with n vertices has n-1 edges
 * A tree with n vertices has exactly one path between any two vertices
 * 
 */
public class isTree {
    public static void main(String[] args) {
        int n = 5;
        int m = 4;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges.add(new ArrayList<>(Arrays.asList(0, 3)));
        edges.add(new ArrayList<>(Arrays.asList(1, 4)));
        System.out.println(new isTree().isTree(n, m, edges));
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int node , int parent , boolean[] visited){
        visited[node] = true;
        for(int adjnode : adj.get(node)){
            if(!visited[adjnode]){
                if(dfs(adj, adjnode , node , visited)){
                    return true; // cycle detected
                }
            } else if(adjnode != parent){
                return true; // cycle detected
            }
        }
        return false; // no cycle
    }

    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        if (m != n - 1) return false; // Tree must have n-1 edges

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());

        for(ArrayList<Integer> edge : edges){
            int src = edge.get(0);
            int dest = edge.get(1);
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }

        boolean[] visited = new boolean[n];
        if (dfs(adj, 0, -1, visited)) return false; 
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }   
}
