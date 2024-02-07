package Graph;
import java.util.*;
public class DFSgraph {
    public static void main(String[] args) {
        DFSgraph sol = new DFSgraph();
    }
        public void dfs(int start,boolean[] visited,ArrayList<Integer> res,ArrayList<ArrayList<Integer>> adj){
            res.add(start);
            visited[start] = true;
            for(int num:adj.get(start)){
                if(!visited[num]){
                    dfs(num,visited,res,adj);
                }
            }
        }
    // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
            ArrayList<Integer> res = new ArrayList<>();
            boolean[] visited = new boolean[V];
            dfs(0,visited,res,adj);
            return res;
        }
        public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
            ArrayList<ArrayList<Integer>>result=new ArrayList<>();
            ArrayList<ArrayList<Integer>>neighbourlist=new ArrayList<>();
            for(int i=0;i<v;i++){
                neighbourlist.add(new ArrayList<>());
            }
            boolean[] vis=new boolean[v];
            for(int i=0;i<e;i++){
                int a=edges.get(i).get(0);
                int b=edges.get(i).get(1);
                neighbourlist.get(a).add(b);
                neighbourlist.get(b).add(a);
            }
            for(int i=0;i<v;i++){
                ArrayList<Integer>temp=new ArrayList<>();
                if(!vis[i]){
                    dfs(i, neighbourlist, vis, temp);
                    result.add(temp);
                }
            }
            return result;
        }
        public static void dfs(int node,ArrayList<ArrayList<Integer>>adj,boolean vis[],ArrayList<Integer>list){
            vis[node]=true;
            list.add(node);
            for(Integer it: adj.get(node)){
                if(!vis[it]){
                    dfs(it, adj, vis, list);
                }
            }
        }
    }



