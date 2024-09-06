package Graph;
import  java.util.*;

/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
Find the number of strongly connected components in the graph.
 */
public class KosarajuAlgo {
    public void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack){
        visited[node] = true;
        for(int adjnode : adj.get(node)){
            if(!visited[adjnode]){
                dfs(adjnode,visited,adj,stack);
            }
        }
        stack.push(node);
    }
    public void dfs3(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        for(int adjnode : adj.get(node)){
            if(!visited[adjnode]){
                dfs3(adjnode,visited,adj);
            }
        }
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<V;i++){
            if(!visited[i]){
                dfs(i,visited,adj,stack);
            }
        }
        ArrayList<ArrayList<Integer>> reversegraph = new ArrayList<>();
        for(int i = 0;i<V;i++){
            reversegraph.add(new ArrayList<>());
        }
        for(int i  = 0;i<V;i++){
            visited[i] = false;
            for(int adjnode : adj.get(i)){
                reversegraph.get(adjnode).add(i);
            }
        }
        int scc = 0;
        for(int i = 0;i<V;i++){
            int node = stack.pop();
            if(!visited[node]){
                scc++;
                dfs3(node,visited,reversegraph);
            }
        }
        return scc;

    }
}
