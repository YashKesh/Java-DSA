 package Graph;
import java.util.*;
/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1.
The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i,
meaning there is an edge from node i to each node in graph[i].
A node is a terminal node if there are no outgoing edges.
A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
Example 1:

Illustration of graph
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
 */
public class EventualSafeStates {
    public static void main(String[] args) {
        EventualSafeStates sol = new EventualSafeStates();
        System.out.println(sol.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}));
    }

        public  boolean dfs(int node,int[][] graph,int[] vis,int[] pathvisited,int[] check){
            vis[node] = 1;
            pathvisited[node] = 1;
            check[node] = 0;
            for(int num: graph[node]){
                if(vis[num]==0){
                    if(dfs(num,graph,vis,pathvisited,check)==true){
                        check[node] = 0;
                        return true;
                    }
                }else if(pathvisited[num]!=0){
                    check[node] = 0;
                    return true;
                }
            }
            check[node] = 1;
            pathvisited[node] =0;
            return false;
        }
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int V = graph.length;
            int[] vis = new int[V];
            int[] pathvisited = new int[V];
            int[] check = new int[V];
            for(int i = 0;i<V;i++){
                dfs(i,graph,vis,pathvisited,check);
            }
            List<Integer> res = new ArrayList<>();
            for(int i = 0;i<V;i++){
                if(check[i]==1){
                    res.add(i);
                }
            }
            return res;
        }
    }

