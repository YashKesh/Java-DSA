package Graph;
import java.util.*;
/*
 * You are given an adjacency list, adj of Undirected Graph having unit weight of the edges, 
 * find the shortest path from src to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.
 */
public class ShortestDistancInUndirectedGraph {
        public static void main(String[] args) {
               ShortestDistancInUndirectedGraph sol = new ShortestDistancInUndirectedGraph();
            }

        public int[] shortestPath(int[][] edges,int n,int m ,int src) {
            // Code here
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0;i<n+1;i++){
                adj.add(new ArrayList<>());
            }
            for(int i = 0;i<m;i++){
                adj.get(edges[i][0]).add(edges[i][1]);
                adj.get(edges[i][1]).add(edges[i][0]);
            }
            int[] dist = new int[n+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[src] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            while(!q.isEmpty()){
                int node = q.remove();
                for(int sep : adj.get(node)){
                    if(dist[sep] > dist[node]){
                        dist[sep] = dist[node] + 1;
                        q.add(sep);
                    }
                }

            }
            for(int i = 0; i < n+1 ; i ++ ){
                if (dist[i] == Integer.MAX_VALUE){
                    dist[i] = -1;
                }
            }
            return dist;

        }
    }

