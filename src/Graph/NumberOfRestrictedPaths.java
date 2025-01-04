package Graph;
import java.util.*;
/*
 * There is an undirected weighted connected graph. You are given a positive integer n which denotes that the graph 
 * has n nodes labeled from 1 to n, and an array edges where each edges[i] = [ui, vi, weighti] denotes that there is an edge
 *  between nodes ui and vi with weight equal to weighti.

A path from node start to node end is a sequence of nodes [z0, z1, z2, ..., zk] such that z0 = start and zk = end and 
there is an edge between zi and zi+1 where 0 <= i <= k-1.

The distance of a path is the sum of the weights on the edges of the path. Let distanceToLastNode(x) denote the 
shortest distance of a path between node n and node x. A restricted path is a path that also satisfies that 
distanceToLastNode(zi) > distanceToLastNode(zi+1) where 0 <= i <= k-1.

Return the number of restricted paths from node 1 to node n. Since that number may be too large, return it modulo 109 + 7.
 */
public class NumberOfRestrictedPaths {
        private static final int MOD = 1_000_000_007;

        private int countPaths(int node, int n, ArrayList<ArrayList<Pair>> adj, int[] dist, int[] dp) {
            if (node == n) {
                return 1;
            }
            if (dp[node] != -1) {
                return dp[node];
            }

            int totalPaths = 0;
            for (Pair neighbor : adj.get(node)) {
                if (dist[node] > dist[neighbor.first]) {
                    totalPaths = (totalPaths + countPaths(neighbor.first, n, adj, dist, dp)) % MOD;
                }
            }
            
            dp[node] = totalPaths;
            return totalPaths; 
        }

        public int countRestrictedPaths(int n, int[][] edges) {
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
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

            PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
            pq.add(new Pair(0, n));
            dist[n] = 0;

            while (!pq.isEmpty()) {
                Pair current = pq.poll();
                int src = current.second;
                int wt = current.first;

                for (Pair neighbor : adj.get(src)) {
                    int adjNode = neighbor.first;
                    int adjWt = neighbor.second;

                    if (wt + adjWt < dist[adjNode]) {
                        dist[adjNode] = wt + adjWt;
                        pq.add(new Pair(dist[adjNode], adjNode));
                    }
                }
            }

            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);

            return countPaths(1, n, adj, dist, dp);
        }
    }


