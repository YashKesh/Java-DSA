package CodeVita;
import java.util.Scanner;

public class MazeRunner {
    public static int minDistance = Integer.MAX_VALUE;
    public static int minthrees = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] maze = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[rows][cols];


        int startRow = scanner.nextInt();
        int startCol = scanner.nextInt();

        int targetRow = scanner.nextInt();
        int targetCol = scanner.nextInt();

        dfs(maze, visited, startRow, startCol, targetRow, targetCol, 0, 0,rows,cols,dp);

        if (minDistance == Integer.MAX_VALUE) {
            System.out.println("STUCK");
        } else {
            System.out.println(minDistance);
        }
    }

    private static void dfs(int[][] maze, boolean[][] visited, int startRow, int startCol, int targetRow, int targetCol, int distance, int twos,int rows,int cols,int[][] dp) {
        if(startRow == targetRow && startCol == targetCol){
            minDistance = Math.min(minDistance,distance);
            return;
        }
        if(maze[startRow][startCol]==1){
            return;
        }
        if(startRow>=rows || startCol>=cols) {
            return;
        }
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,-1,0,1};
        visited[startRow][startCol] = true;
        int count = 0;
        for(int i = 0;i<4;i++){
            int newrow = startRow + delrow[i];
            int newcol = startCol + delcol[i];
            if(newrow>=0 && newrow<rows && newcol>=0 && newcol<cols && maze[newrow][newcol]==2 && visited[newrow][newcol]==false && twos<3){
                dfs(maze, visited, newrow, newcol, targetRow, targetCol, distance+1, twos+1, rows, cols,dp);
            }
            else if(newrow>=0 && newrow<rows && newcol>=0 && newcol<cols && maze[newrow][newcol]==0 && visited[newrow][newcol]==false){
                dfs(maze, visited, newrow, newcol, targetRow, targetCol, distance+1, twos, rows, cols, dp);
            }
            else if(newrow>=0 && newrow<rows && newcol>=0 && newcol<cols && maze[newrow][newcol]==3 && visited[newrow][newcol]==false && twos>2){
                dfs(maze, visited, newrow, newcol, targetRow, targetCol, distance+1, twos, rows, cols, dp);
            }
            else if(newrow>=0 && newrow<rows && newcol>=0 && newcol<cols && maze[newrow][newcol]!=1 && visited[newrow][newcol]==false){
                dfs(maze, visited, newrow, newcol, targetRow, targetCol, distance+1, twos, rows, cols, dp);
            }

        }
        visited[startRow][startCol] = false;
    }



}
