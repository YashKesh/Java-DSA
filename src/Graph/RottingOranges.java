package Graph;
import  java.util.*;
/*
 * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * 
 */
class Pair3{
    int first;
    int second;
    int third;
    public Pair3(int first,int second,int third){
        this.third = third;
        this.first = first;
        this.second = second;
    }
}
public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges sol = new RottingOranges();
        System.out.println(sol.orangesRotting(new int[][]{{1,1,0},{1,2,1},{2,1,1}}));
    }
    public int bfs(int[][] grid,Queue<Pair3> q,int[][] visited,int countfresh){
        int n = grid.length;
        int m = grid[0].length;
        int[] rowdel = {-1,0,+1,0};
        int[] coldel = {0,+1,0,-1};
        int maxtime = 0;
        while(!q.isEmpty()){
            int a = q.peek().first;
            int b = q.peek().second;
            int c = q.peek().third;
            maxtime = Math.max(maxtime,c);
            // int n = q.size();
            q.remove();
            for(int i =0;i<4;i++){
                int checkrow = a + rowdel[i];
                int checkcol = b + coldel[i];
                if(checkrow>=0 && checkrow<n && checkcol>=0 && checkcol<m && visited[checkrow][checkcol]!=2 && grid[checkrow][checkcol]==1){
                    q.add(new Pair3(checkrow,checkcol,c+1));
                    visited[checkrow][checkcol] = 2;
                    countfresh--;
                }
            }

        }
        if(countfresh!=0){
            return -1;
        }
        return maxtime;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair3> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        int countfresh = 0;
        for(int i  = 0;i<n;i++){
            for(int j  = 0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair3(i,j,0));
                    visited[i][j] = 2;
                }
                else{
                    visited[i][j] = 0;
                }
                if(grid[i][j]==1){
                    countfresh++;
                }
            }
        }
        return bfs(grid,q,visited,countfresh);
    }
    }

