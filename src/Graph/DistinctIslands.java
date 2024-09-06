package Graph;
import java.util.ArrayList;
import java.util.HashSet;

public class DistinctIslands {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 1}
        };

        DistinctIslands solution = new DistinctIslands();
        var result = solution.distinctIsland(grid,4,4);

        System.out.println("Number of distinct islands: " + result);
    }
//    public class Solution
//    {
        public static void dfs(int i,int j,int[][] arr,ArrayList<Pair> temp, int n, int m,int[][] visited,int row0,int col0){
            visited[i][j] = 1;
            int[] delrow = {1,0,-1,0};
            int[] delcol = {0,-1,0,1};
            temp.add(new Pair(i-row0,j-col0));
            for(int k = 0;k<4;k++){
                int nrow = i + delrow[k];
                int ncol = j + delcol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && arr[nrow][ncol]==1 && visited[nrow][ncol]==0){
                    dfs(nrow, ncol, arr, temp, n, m, visited, row0, col0);
                }
            }
        }
        public static int distinctIsland(int [][] arr, int n, int m)
        {
            //write your code here
            int[][] visited = new int[n][m];
            HashSet<ArrayList<Pair>> set = new HashSet<>();
            for(int i = 0;i<n;i++){
                for(int j  = 0;j<m;j++){
                    if(visited[i][j]==0 && arr[i][j]==1){
                        ArrayList<Pair> temp = new ArrayList<>();
                        dfs(i,j,arr,temp,n,m,visited,i,j);
                        for(Pair nums : temp){
                            System.out.println(nums);
                        }
                        set.add(temp);
                    }
                }
            }
            return set.size();

        }
    }

//}
