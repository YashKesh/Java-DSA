package Graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class CycleDetectionInUndirected {
    public static void main(String[] args) {
        CycleDetectionInUndirected sol = new CycleDetectionInUndirected();
        System.out.println(cycleDetection(new int[][]{{1,2},{2,3},{3,4},{4,1}},4,5));
    }

//    public class Solution {
        public static boolean solve(int src, int[][] edges, boolean[] visited, ArrayList<ArrayList<Integer>> adjlist) {
            visited[src] = true;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(src, -1));
            while (!q.isEmpty()) {
                int u = q.peek().first;
                int v = q.peek().second;
                q.remove();
                for (int node : adjlist.get(u)) {
                    if (!visited[node]) {
                        visited[node] = true;
                        q.add(new Pair(node, u));
                    } else if (node != v) {
                        return true;
                    }
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
                    boolean ans = solve(i, edges, visited, adjlist);
                    if (ans) {
                        return "Yes";
                    }
                }
            }
            return "No";
        }
    }

//}
