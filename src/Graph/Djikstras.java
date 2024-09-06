package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Djikstras {

    public static void main(String[] args) {
        int V = 2;
        // ArrayList<ArrayList<ArrayList<Integer>>> adj = {{{1, 9}}, {{0, 9}}};
        int S = 0;
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.first - y.first);
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e7);
        dist[S] = 0;
        pq.add(new Pair(0,S));
        while(!pq.isEmpty()){
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            for(int i = 0;i<adj.get(node).size();i++){
                int wt = adj.get(node).get(i).get(1);
                int adjnode = adj.get(node).get(i).get(0);
                if(wt + dis < dist[adjnode]){
                    dist[adjnode] = wt + dis;
                    pq.add(new Pair(dist[adjnode],adjnode));
                }
            }
        }
        return dist;
        
    }
}

