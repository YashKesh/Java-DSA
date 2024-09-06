package Graph;
import java.util.*;
/*
You are given a weighted undirected graph having n vertices numbered from 1 to n and m edges
along with their weights. Find the shortest weight path between the vertex 1 and the vertex n,
if there exists a path, and return a list of integers whose first element is the weight of the path,
and the rest consist of the nodes on that path. If no path exists, then return a list containing a single element -1.

The input list of edges is as follows - {a, b, w}, denoting there is an edge between a and b, and w is the weight of that edge.

Note: The driver code here will first check if the weight of the path returned is equal to the sum
of the weights along the nodes on that path, if equal it will output the weight of the path,
else -2. In case the list contains only a single element (-1) it will simply output -1.

Examples :

Input: n = 5, m= 6, edges = [[1, 2, 2], [2, 5, 5], [2, 3, 4], [1, 4, 1], [4, 3, 3], [3, 5, 1]]
Output: 5
Explanation: Shortest path from 1 to n is by the path 1 4 3 5 whose weight is 5.
 */
public class ShortestPathInWeightedUndirectedGraph {

        public List<Integer> shortestPath(int n, int m, int edges[][]) {
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.first - y.first);
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < edges.length; i++) {
                int src = edges[i][0];
                int dest = edges[i][1];
                int wt = edges[i][2];
                adj.get(src).add(new Pair(dest, wt));
                adj.get(dest).add(new Pair(src, wt));
            }
            int[] dist = new int[n + 1];
            int[] parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                dist[i] = (int) 1e7;
                parent[i] = i;
            }
            dist[1] = 0;
            pq.add(new Pair(0, 1));
            while (!pq.isEmpty()) {
                int dis = pq.peek().first;
                int node = pq.peek().second;
                pq.remove();
                for (Pair adjPair : adj.get(node)) {
                    int wt = adjPair.second;
                    int adjnode = adjPair.first;
                    if (wt + dis < dist[adjnode]) {
                        dist[adjnode] = wt + dis;
                        pq.add(new Pair(dist[adjnode], adjnode));
                        parent[adjnode] = node;
                    }
                }
            }
            List<Integer> path = new ArrayList<>();
            if (dist[n] == (int) 1e7) {
                path.add(-1);
                return path;
            }
            int node = n;
            while (parent[node] != node) {
                path.add(node);
                node = parent[node];
            }
            path.add(1); // Adding the starting node (1)
            Collections.reverse(path);
            path.add(0, dist[n]); // Adding the shortest distance at the beginning
            return path;
        }
    }

