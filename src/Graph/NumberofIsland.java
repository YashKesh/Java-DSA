package Graph;
import java.util.*;
//class Pair{
//    int first;
//    int second;
//    public Pair(int first,int second){
//        this.first = first;
//        this.second = second;
//    }
//}
public class NumberofIsland {
    public static void main(String[] args) {
        NumberofIsland sol = new NumberofIsland();
        System.out.println(sol.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
        System.out.println(sol.numIslands1(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }
//for 8 direction solution
    public void solve(boolean[][] visited,int row1,int col1,char[][] grid){
        visited[row1][col1] = true;
        Queue<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(row1,col1));
        int n = grid.length;
        int m = grid[0].length;
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();
            for(int rowdel = -1 ;rowdel<=1;rowdel++){
                for(int coldel= -1;coldel<=1;coldel++){
                    int checkrow = row + rowdel;
                    int checkcol = col + coldel;
                    if (checkrow >= 0 && checkrow < n && checkcol >= 0 && checkcol < m && grid[checkrow][checkcol] == '1' && !visited[row + rowdel][col + coldel]) {
                        q.add(new Pair(checkrow, checkcol));
                        visited[row + rowdel][col + coldel] = true; // Fix the visited array index
                    }

                }
            }
        }
    }
    // Function to find the number of islands.
    public int numIslands1(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i  = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    solve(visited,i,j,grid,n,m);
                }
            }
        }
        return count;
    }

//solution for horizontal and vertical only
//    class Solution {
        public void solve(boolean[][] visited,int row1,int col1,char[][] grid,int n,int m){
            visited[row1][col1] = true;
            Queue<Pair> q= new LinkedList<Pair>();
            q.add(new Pair(row1,col1));
            while(!q.isEmpty()){
                int row = q.peek().first;
                int col = q.peek().second;
                q.poll();
                for(int rowdel = -1 ;rowdel<=1;rowdel++){
                    for(int coldel= -1;coldel<=1;coldel++){
                        if(rowdel==0 || coldel==0){
                            int checkrow = row + rowdel;
                            int checkcol = col + coldel;
                            if (checkrow >= 0 && checkrow < n && checkcol >= 0 && checkcol < m && grid[checkrow][checkcol] == '1' && !visited[row + rowdel][col + coldel]) {
                                q.add(new Pair(checkrow, checkcol));
                                visited[row + rowdel][col + coldel] = true; // Fix the visited array index
                            }

                        }
                    }
                }
            }
        }
        public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            boolean[][] visited = new boolean[n][m];
            int count = 0;
            for(int i  = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(grid[i][j]=='1' && !visited[i][j]){
                        count++;
                        solve(visited,i,j,grid,n,m);
                    }
                }
            }
            return count;
        }
    }
//}
