package Graph;
import java.util.*;
/*
 * You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. 
 * You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge 
    connecting vertices ai and bi.
 * Return the number of complete connected components of the graph.
    A connected component is a subgraph of a graph in which there exists a path between any two vertices, 
    and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
    A connected component is said to be complete if there exists an edge between every pair of its vertices.
 */
class CountNumberOfCompleteComponents {
    public static void main(String[] args) {
        
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited,int parent,ArrayList<Pair> components,int componentscount,int edgecount){
        visited[node] = true;
        componentscount++;
        for(int adjnode : adj.get(node)){
            if(!visited[adjnode]){
                dfs(adjnode,adj,visited,node,components,componentscount,edgecount+1);
            }
            else if(visited[adjnode] && adjnode != parent){
                components.add(new Pair(componentscount,edgecount+1));
            }

        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
     for(int i = 0;i<n;i++){
        adj.add(new ArrayList<>());
     }
     for(int[] edge : edges){
        int src = edge[0];
        int dest = edge[1];
        adj.get(src).add(dest);
        adj.get(dest).add(src);
     }   
     boolean[] visited = new boolean[n];
     ArrayList<Pair> components = new ArrayList<>();
     for(int i = 0;i<n;i++){
        if(!visited[i]){
            dfs(i,adj,visited,-1,components,0,0);
        }
     }
     int completecomp = 0;
     for(Pair comp : components){
        int compcount = comp.first;
        int edcount = comp.second;
        if(edcount == (compcount * (compcount -1 ))/2){
            completecomp++;
        }
     }
     return completecomp;
    
    }
}