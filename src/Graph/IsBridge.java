package Graph;

import java.util.ArrayList;
/*
 * Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not.
 * Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.
 */
public class IsBridge {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        System.out.println(isBridge(V, adj, 1, 2));
    }
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d)
    {
        // Remove the edge in both directions
        adj.get(c).remove(Integer.valueOf(d));
        adj.get(d).remove(Integer.valueOf(c));

        DisjointSet ds = new DisjointSet(V);
        
        // Union remaining edges
        for(int i = 0; i < V; i++){
            for(int j : adj.get(i)){
                ds.unionBySize(i, j);
            }
        }

        // If c and d are still connected, it's not a bridge
        if(ds.findParent(c) == ds.findParent(d)) {
            return 0;
        }
        return 1;
    }
}
