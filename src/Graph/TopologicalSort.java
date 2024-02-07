package Graph;
import java.util.*;
public class TopologicalSort {
    public static void main(String[] args) {

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
