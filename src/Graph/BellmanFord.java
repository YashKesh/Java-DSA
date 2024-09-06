package Graph;
import java.util.*;
public class BellmanFord {

        static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
            // Write your code here
            int[] dist = new int[V];
            Arrays.fill(dist,(int)1e8);
            dist[S] = 0;
            for(int i = 0;i<V-1;i++){
                for(int j = 0;j<edges.size();j++){
                    int src = edges.get(j).get(0);
                    int dst = edges.get(j).get(1);
                    int wt = edges.get(j).get(2);
                    if(dist[dst]> dist[src] + wt && dist[src]!=(int)1e8){
                        dist[dst] = dist[src] + wt;
                    }
                }
            }
            for(ArrayList<Integer> list : edges){
                int src = list.get(0);
                int dst = list.get(1);
                int wt = list.get(2);
                if(dist[src]!=(int)1e8 && dist[src] + wt <dist[dst]){
                    int[] temp = new int[1];
                    temp[0] = -1;
                    return temp;
                }
            }
            return dist;
        }
    }

