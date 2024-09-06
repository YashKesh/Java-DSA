package Graph;
import java.util.*;

class Pairnode {
    int node;
    int distance;
    public Pairnode(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}
public class CheapestStopsWithinKStops {


        public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
            // Code here
            Queue<Tuple> pq = new LinkedList<>();
            int[] dist = new int[n];
            Arrays.fill(dist,(int)1e7);
            ArrayList<ArrayList<Pairnode>> adj = new ArrayList<>();
            for(int i = 0;i<n;i++){
                adj.add(new ArrayList<>());
            }
            for(int i = 0;i<flights.length;i++){
                adj.get(flights[i][0]).add(new Pairnode(flights[i][1],flights[i][2]));
            }
            dist[src] = 0;
            pq.add(new Tuple(0,src,0));
            while(!pq.isEmpty()){
                int price = pq.peek().third;
                int node = pq.peek().second;
                int stops = pq.peek().first;
                pq.poll();
                if(stops>k)continue;
                for(int i = 0;i<adj.get(node).size();i++){
                    int priceadj = adj.get(node).get(i).distance;
                    int adjnode = adj.get(node).get(i).node;
                    if(dist[adjnode]> priceadj + price && stops<=k+1){
                        dist[adjnode] = priceadj + price;
                        pq.add(new Tuple(stops +1,adjnode,dist[adjnode]));
                    }
                }
            }
            if(dist[dst] == (int)1e7) return -1;
            return dist[dst];
        }
    }

