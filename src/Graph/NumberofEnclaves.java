package Graph;
import  java.util.*;
public class NumberofEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };

        NumberofEnclaves solution = new NumberofEnclaves();
        int result = solution.numEnclaves(grid);

        System.out.println("Number of enclaves: " + result);
    }
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
//    class Solution {
public int numEnclaves(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][] visited = new int[n][m];
    Queue<Pair> q = new LinkedList<>();

    // First, enqueue all land cells on the boundary
    for (int i = 0; i < n; i++) {
        if (grid[i][0] == 1) {
            q.add(new Pair(i, 0));
            visited[i][0] = 1;
        }
        if (grid[i][m - 1] == 1) {
            q.add(new Pair(i, m - 1));
            visited[i][m - 1] = 1;
        }
    }
    for (int j = 0; j < m; j++) {
        if (grid[0][j] == 1) {
            q.add(new Pair(0, j));
            visited[0][j] = 1;
        }
        if (grid[n - 1][j] == 1) {
            q.add(new Pair(n - 1, j));
            visited[n - 1][j] = 1;
        }
    }

    int[] delrow = {-1, 0, 1, 0};
    int[] delcol = {0, 1, 0, -1};

    while (!q.isEmpty()) {
        int row = q.peek().first;
        int col = q.peek().second;
        q.poll();
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0) {
                q.add(new Pair(nrow, ncol));
                visited[nrow][ncol] = 1;
            }
        }
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (visited[i][j] == 0 && grid[i][j] == 1) {
                count++;
            }
        }
    }
    return count;
}
    }
//}
