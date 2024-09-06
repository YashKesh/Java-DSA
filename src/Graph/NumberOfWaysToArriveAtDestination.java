package Graph;
import java.util.*;
/*
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some
intersections. The inputs are generated such that you can reach any intersection from any other intersection and that
there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between
intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from
intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large,
return it modulo 109 + 7.

Example 1:

Input:
n=7, m=10
edges= [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]

Output:
4
Explaination:

The four ways to get there in 7 minutes are:
- 0  6
- 0  4  6
- 0  1  2  5  6
- 0  1  3  5  6
 */
class PairDistance
{
    long dist;
    int node;
    PairDistance(long dist, int node)
    {
        this.dist=dist;
        this.node=node;
    }
}
public class NumberOfWaysToArriveAtDestination {

        static int countPaths(int n, List<List<Integer>> roads) {
            ArrayList < ArrayList <PairDistance>> adj = new ArrayList < > ();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList < > ());
            }
            int m = roads.size();
            for (int i = 0; i < m; i++) {
                int u = roads.get(i).get(0);
                int v = roads.get(i).get(1);
                int w = roads.get(i).get(2);
                adj.get(u).add(new PairDistance(w, v));
                adj.get(v).add(new PairDistance(w, u));
            }
            int ways[]=new int[n];
            long dist[]=new long[n];
            Arrays.fill(dist,Integer.MAX_VALUE);
            PriorityQueue<PairDistance> q=new PriorityQueue<>((x, y) -> Long.compare(x.dist, y.dist));
            dist[0]=0;
            ways[0] = 1;
            q.add(new PairDistance((long)0,0));
            int mod = (int)(1e9 + 7);
            while(!q.isEmpty())
            {
                PairDistance p=q.poll();
                int node=p.node;
                long d=p.dist;
                if (d > dist[node]) continue;

                for(PairDistance x:adj.get(node))
                {
                    int neighbor=x.node;
                    long dst=x.dist;
                    if(d+dst<dist[neighbor])
                    {
                        dist[neighbor]=dst+d;
                        q.add(new PairDistance(dist[neighbor],neighbor));
                        ways[neighbor] = ways[node]%mod;
                    }
                    else if(d+dst==dist[neighbor])
                    {
                        ways[neighbor] = (ways[neighbor] + ways[node]) %mod;
                    }
                }
            }
            return ways[n - 1] ;
        }
    }

