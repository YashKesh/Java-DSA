package Graph;

public class ConnectingTheGraph {
    public int Solve(int n, int[][] edge) {
        // Code here
        DisjointSet ds = new DisjointSet(n);
        int extras = 0;
        for(int i = 0;i<edge.length;i++){
            if(ds.findParent(edge[i][0]) == ds.findParent(edge[i][1]) ){
                extras++;
            }else{
                ds.unionBySize(edge[i][0],edge[i][1]);
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            if(ds.parent.get(i) == i){
                count++;
            }
        }
        int ans = count - 1;
        if (extras >= ans){
            return ans;
        }
        return -1;
    }
}
