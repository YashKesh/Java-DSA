package Graph;
import java.util.*;
public class ArticulationPoints {
    public int timer = 1;
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        int[] tin  = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                dfs(i,-1,adj,visited,mark,tin,low);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if(mark[i] == 1){
                ans.add(i);
            }
        }
        if(ans.size() == 0){
            ans.add(-1);
        }
        return ans;
    }

    private void dfs(int node,int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] mark, int[] tin, int[] low) {
        visited[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        for(int adjnode : adj.get(node)){

            if(adjnode == parent)continue;
            if(!visited[adjnode]){
                dfs(adjnode,node,adj,visited,mark,tin,low);
                low[node] = Math.min(low[node],low[adjnode]);
                if (low[adjnode] > tin[node] && parent != -1){
                    mark[node]  = 1;
                }
                child++ ;
            }else {
                low[node] = Math.min(low[node],tin[adjnode]);
            }
        }
        if(child > 1 && parent == -1){
            mark[node] = 1;
        }
    }
}
