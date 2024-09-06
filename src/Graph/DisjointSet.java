package Graph;

import java.util.*;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n){
        for(int i = 0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public  void  unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v){return;}
        if(size.get(ulp_u) > size.get(ulp_v)){
            int size_v = size.get(ulp_v);
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u) + size_v);
        } else {
            int size_u = size.get(ulp_u);
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v) + size_u);
        }
    }
    public void unionByRank(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u==ulp_v)return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        } else if (rank.get(ulp_u)>rank.get(ulp_v)) {
            parent.set(ulp_v,ulp_u);
        }else{
            parent.set(ulp_v,ulp_u);
            int rank_p = rank.get(ulp_u);
            rank.set(ulp_u,rank_p + 1);
        }
    }


}
