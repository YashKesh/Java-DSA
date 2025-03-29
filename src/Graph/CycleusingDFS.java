package Graph;
import java.util.*;
/*
 * Given an undirected graph represented by the number of vertices and a list of edges,
 * return the number of vertices in the cycle.
 */
public class CycleusingDFS {

    public static void main(String[] args) {
        CycleusingDFS sol = new CycleusingDFS();
        System.out.println(cycleDetection(new int[][]{{1,2},{2,3},{3,4},{4,1}},4,5));
    }
//    public class Solution {
        public static boolean solve(int src, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adjlist) {
            visited[src] = true;
            for(int node: adjlist.get(src)){
                if(visited[node]==false){
                    if(solve(node, src, visited, adjlist)){
                        return true;
                    }
                }
                else if(node!=parent){
                    return true;
                }
            }
            return false;
        }

        public static String cycleDetection(int[][] edges, int n, int m) {
            ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
            for (int i = 0; i <=n; i++) {
                adjlist.add(new ArrayList<>());
            }
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                adjlist.get(u).add(v);
                adjlist.get(v).add(u);
            }
            boolean[] visited = new boolean[n+1];
            Arrays.fill(visited, false);
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    boolean ans = solve(i,-1,visited,adjlist);
                    if (ans) {
                        return "Yes";
                    }
                }
            }
            return "No";
        }
    }

//}
