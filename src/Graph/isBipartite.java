package Graph;
import  java.util.*;
public class isBipartite {
    public static void main(String[] args) {

    }
    public boolean dfs(int start,int paint,boolean[] visited,ArrayList<ArrayList<Integer>>adj,int[] color){
        color[start] = paint;
        for(int num : adj.get(start)){
            if(color[num]==-1){
                if(!dfs(num,1 - paint,visited,adj,color)){
                    return false;
                }
            }else if(color[num]==color[start]){
                return false;
            }
        }
        return true;

    }
        public boolean bfs(int start,boolean[] visited,ArrayList<ArrayList<Integer>>adj,int[] color){
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            color[start] = 0;
            while(!q.isEmpty()){
                int node = q.poll();
                for(int num : adj.get(node)){
                    if(color[num]==-1){
                        color[num] = 1 - color[node];
                        q.add(num);
                    }else if(color[num]==color[node]){
                        return false;
                    }
                }
            }
            return true;
        }
        public boolean isBipartit(int V, ArrayList<ArrayList<Integer>>adj)
        {
            // Code here
            boolean[] visited = new boolean[V];
            int[] color = new int[V];
            Arrays.fill(color,-1);
            for(int i = 0;i<V;i++){
                if(color[i]==-1){
                    if(!bfs(i,visited,adj,color)){
                        return false;
                    }
                }
            }
            return true;
        }

}
