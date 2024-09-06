package Graph;
import java.util.*;
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

            return dp[node] = totalPaths;
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


