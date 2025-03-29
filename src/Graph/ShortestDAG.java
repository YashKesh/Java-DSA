package Graph;
import java.util.*;

/**
 * Shortest path in Directed Acyclic Graph
 * banner
 * Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M,
 * where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.
 * Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex,
 * then return -1 for that vertex.**/
public class ShortestDAG {
    public static void main(String[] args) {
        ShortestDAG sol = new ShortestDAG();
        System.out.println();
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        int[] dist = new int[V];
        Arrays.fill(dist , (int)1e9);
        dist[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.first - y.first);
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int nodedist = node.first;
            int vertex = node.second;
            for(Pair adjnodes : adj.get(vertex)){
                int adjnode = adjnodes.first;
                int adjwt = adjnodes.second;
                if(dist[vertex] + adjwt < dist[adjnode]){
                    dist[adjnode] = dist[vertex] + adjwt;
                    pq.add(new Pair(dist[adjnode] , adjnode));
                }
            }
        }
        for(int i = 0;i<V;i++){
            if(dist[i] == (int)1e9){
                dist[i] = -1;
            }
        }
        return dist;
    }
        public void dfs(int start,List<List<Pair>> adj,boolean[] visited,Stack<Integer> stack){
            visited[start] = true;
            for(Pair num : adj.get(start)){
                if(!visited[num.first]){
                    dfs(num.first,adj,visited,stack);
                }
            }
            stack.push(start);
        }
        public int[] shortestPath(int N,int M, int[][] edges) {
            //Code here
            List<List<Pair>> adj = new ArrayList<>();
            for(int i = 0;i<N;i++){
                adj.add(new ArrayList<>());
            }
            for(int i = 0;i<edges.length;i++){
                adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            }
            boolean[] visited = new boolean[N];
            Stack<Integer> stack = new Stack<>();
            for(int i = 0;i<N;i++){
                if(!visited[i]){
                    dfs(i,adj,visited,stack);
                }
            }
            int[] dist = new int[N];
            Arrays.fill(dist,(int)1e9);
            dist[0] = 0;
            while(!stack.isEmpty()){
                int number = stack.pop();
                for(int i = 0;i<adj.get(number).size();i++){
                    int u = adj.get(number).get(i).first;
                    int wt = adj.get(number).get(i).second;
                    if(dist[u]>dist[number]+wt){
                        dist[u] = dist[number]+wt;
                    }
                }
            }
            for(int i = 0;i<dist.length;i++){
                if(dist[i]==1e9){
                    dist[i]=-1;
                }
            }
            return dist;

        }
    }

