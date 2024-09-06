package Graph;
import java.util.*;
public class BFS {
    public static void main(String[] args) {
        // BFS sol = new BFS();
//        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(Arrays.asList(0, 1));
        adj.add(Arrays.asList(0, 2));
        adj.add(Arrays.asList(1, 3));
        adj.add(Arrays.asList(2, 4));
        adj.add(Arrays.asList(3, 4));
        System.out.println(bfsTraversal(5,adj));
    }


//    public class Solution {
        public static void solve(int node, List<Integer> res, boolean[] visited, Map<Integer, List<Integer>> map) {
            Queue<Integer> q = new LinkedList<>();
            q.add(node);
            visited[node]=true;
            while (!q.isEmpty()) {
                int temp = q.poll();
                res.add(temp);
                for (int num : map.get(temp)) {
                    if (!visited[num] ){
                        q.add(num);
                        visited[num]= true;
                    }
                }
            }
        }

        public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
            // Write your code here
            if(adj.isEmpty()){
                return new ArrayList<>();
            }
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < adj.size(); i++) {
                int u = adj.get(i).get(0);
                int v = adj.get(i).get(1);
                if (map.containsKey(u)) {
                    map.get(u).add(v);
                } else {
                    map.put(u, new ArrayList<>());
                    map.get(u).add(v);
                }
                if (map.containsKey(v)) {
                    map.get(v).add(u);
                } else {
                    map.put(v, new ArrayList<>());
                    map.get(v).add(u);
                }
            }
//            System.out.print(map);

            List<Integer> res = new ArrayList<>();
            boolean[] visited = new boolean[n];
            Arrays.fill(visited,false);
            for(int i = 0;i<n;i++){
                if(!visited[i]){
                    solve(i, res, visited, map);
                }
            }
            return res;
        }
    }

//}
