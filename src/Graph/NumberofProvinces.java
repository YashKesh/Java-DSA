package Graph;
import java.util.*;
/*
 * There are n cities. Some of them are connected, while some are not. 
 * If city a is connected directly with city b, and city b is connected directly with city c,
 * then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, 
 * and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 */
public class NumberofProvinces {
    public static void main(String[] args) {
        NumberofProvinces sol = new NumberofProvinces();
        System.out.println(sol.findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }
//    class Solution {
        public void dfs(boolean[] visited,ArrayList<ArrayList<Integer>> adj,int node){
            visited[node] = true;
            for(int i:adj.get(node)){
                if(!visited[i]){
                    dfs(visited,adj,i);
                }
            }
        }
        public int findCircleNum(int[][] isConnected) {
            int v = isConnected.length;
            int e = isConnected[0].length;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<v;i++){
                adj.add(new ArrayList<>());
            }
            for(int i = 0;i<v;i++){
                for(int j =0;j<e;j++){
                    if(isConnected[i][j]==1 && i!=j){
                        adj.get(i).add(j);
                        adj.get(j).add(i);
                    }
                }
            }
            boolean[] visited = new boolean[v];
            int count =0;
            for(int i = 0;i<v;i++){
                if(!visited[i]){
                    count++;
                    dfs(visited,adj,i);
                }
            }
            return count;
        }
    }
//}
