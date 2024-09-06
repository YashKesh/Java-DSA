package Graph;
import java.util.*;
public class BridgesInGraph {
    public int timer = 0;
    private void dfs(int node, int parent, boolean[] visited, int[] tin, int[] low, ArrayList<ArrayList<Integer>> adj, List<List<Integer>> ans) {
        visited[node] = true;
        low[node] = tin[node] = timer;
        timer++;
        for(int adjnode : adj.get(node)){
            if(adjnode == parent)continue;
            if(!visited[adjnode]){
                dfs(adjnode,node,visited,tin,low,adj,ans);
                low[node] = Math.min(low[node],low[adjnode]);
                if(low[adjnode] > tin[node]){
                    ans.add(Arrays.asList(adjnode,node));
                }
            }else{
                low[node] = Math.min(low[node],low[adjnode]);
            }
        }

    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.size(); i++) {
            int u  = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0,-1,visited,tin,low,adj,ans);
        return ans;
    }


}
