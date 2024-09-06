package Graph;
import java.util.*;
public class TopologicalSort {
    public static void main(String[] args) {

    }
    public static int[] bfs(int V,ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[V];
        for(int i = 0;i<V;i++){
            for(int num : adj.get(i)){
                indegree[num]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] toposort = new int[V];
        int j = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            toposort[j++] = node;
            for(int num : adj.get(node)){
                indegree[num]--;
                if(indegree[num]==0){
                    q.add(num);
                }
            }
        }
        return toposort;
    }
    public static void dfs(int node,int[] visited,ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack){
        visited[node] = 1;
        for(int num: adj.get(node)){
            if(visited[num]==0){
                dfs(num,visited,adj,stack);
            }
        }
        stack.push(node);
    }
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<V;i++){
            if(visited[i]==0){
                dfs(i,visited,adj,stack);
            }
        }
        int[] res = new int[V];
        int i = 0;
        while(!stack.isEmpty()){
            res[i] = stack.peek();
            stack.pop();
            i++;
        }
        return res;
    }
}
