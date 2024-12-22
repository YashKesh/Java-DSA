package Graph;
//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

//public class KruskalAlgo {
//    static BufferedReader br;
//    static PrintWriter ot;
//
//    public static void main(String args[]) throws IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
//        ot = new PrintWriter(System.out);
//        int t = Integer.parseInt(br.readLine().trim());
//        while (t-- > 0) {
//            String s[] = br.readLine().trim().split(" ");
//            int V = Integer.parseInt(s[0]);
//            int E = Integer.parseInt(s[1]);
//            List<List<int[]>> list = new ArrayList<>();
//            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
//            for (int i = 0; i < E; i++) {
//                s = br.readLine().trim().split(" ");
//                int a = Integer.parseInt(s[0]);
//                int b = Integer.parseInt(s[1]);
//                int c = Integer.parseInt(s[2]);
//                list.get(a).add(new int[] {b, c});
//                list.get(b).add(new int[] {a, c});
//            }
//            ot.println(new KruskalAlgo().spanningTree(V, E, list));
//        }
//        ot.close();
//    }
//}
// } Driver Code Ends

//class DisjointSet {
//    List<Integer> rank = new ArrayList<>();
//    List<Integer> size = new ArrayList<>();
//    List<Integer> parent = new ArrayList<>();
//    public DisjointSet(int n){
//        for(int i = 0;i<=n;i++){
//            rank.add(0);
//            parent.add(i);
//            size.add(1);
//        }
//    }
//    public int findParent(int node){
//        if(node == parent.get(node)){
//            return node;
//        }
//        int ulp = findParent(parent.get(node));
//        parent.set(node,ulp);
//        return parent.get(node);
//    }
//    public  void  unionBySize(int u,int v){
//        int ulp_u = findParent(u);
//        int ulp_v = findParent(v);
//        if(ulp_u == ulp_v){return;}
//        if(size.get(ulp_u) > size.get(ulp_v)){
//            int size_v = size.get(ulp_v);
//            parent.set(ulp_v,ulp_u);
//            size.set(ulp_u,size.get(ulp_u) + size_v);
//        } else  {
//            int size_u = size.get(ulp_u);
//            parent.set(ulp_u,ulp_v);
//            size.set(ulp_v,size.get(ulp_v) + size_u);
//        }
//    }
//    public void unionByRank(int u,int v){
//        int ulp_u = findParent(u);
//        int ulp_v = findParent(v);
//        if(ulp_u==ulp_v)return;
//        if(rank.get(ulp_u) < rank.get(ulp_v)){
//            parent.set(ulp_u,ulp_v);
//        } else if (rank.get(ulp_u)>rank.get(ulp_v)) {
//            parent.set(ulp_v,ulp_u);
//        }else{
//            parent.set(ulp_v,ulp_u);
//            int rank_p = rank.get(ulp_u);
//            rank.set(ulp_u,rank_p + 1);
//        }
//    }
//
//
//}
//// User function Template for Java
class Edge implements Comparable<Edge>{
    int src;
    int dest;
    int weight;
    public Edge(int src,int dest,int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    public int compareTo(Edge edge){
        return this.weight - edge.weight;
    }
}
class KruskalAlgo {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        List<Edge> edges  = new ArrayList<Edge>();  
        for(int i = 0;i<V;i++){
            for(int j = 0;j<adj.get(i).size();j++){
                int[] ar = adj.get(i).get(j);
                int adjnode = ar[0];
                int wt = ar[1];
                int node = i;
                Edge temp = new Edge(node,adjnode,wt);
                edges.add(temp);
            }
        }
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(V+1);
        int mstwt = 0;
        for(int i = 0;i<edges.size();i++){
            Edge temp = edges.get(i);
            int wt = temp.weight;
            int u = temp.src;
            int v = temp.dest;
            if(ds.findParent(u)!=ds.findParent(v)){
                mstwt+=wt;
                ds.unionBySize(u,v);
            }
        }
        return mstwt;


    }
}
