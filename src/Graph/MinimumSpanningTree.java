package Graph;
import java.util.*;
class TupleNode {
    int wt;
    int node;

    public TupleNode(int wt, int node){
        this.wt = wt;
        this.node = node;

    }
}
public class MinimumSpanningTree {

        static int spanningTree(int V, int E, List<List<int[]>> adj) {
            boolean[] visited = new boolean[V];
            int sum = 0;
            PriorityQueue<TupleNode> pq = new PriorityQueue<TupleNode>((x, y) -> x.wt - y.wt);
            pq.add(new TupleNode(0, 0));

            while (!pq.isEmpty()) {
                TupleNode current = pq.poll();
                int wt = current.wt;
                int node = current.node;

                if (visited[node]) continue;

                visited[node] = true;
                sum += wt;

                for (int[] adjNode : adj.get(node)) {
                    int adjVertex = adjNode[0];
                    int edgeWeight = adjNode[1];

                    if (!visited[adjVertex]) {
                        pq.add(new TupleNode(edgeWeight, adjVertex));
                    }
                }
            }
            return sum;
        }
    }

