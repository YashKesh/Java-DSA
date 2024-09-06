package Backtracking;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ScubaDivingPaths {

        static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        static List<String> availablePaths = new ArrayList<>();
        static List<String> feasiblePaths = new ArrayList<>();

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int capacity = scanner.nextInt();
            int originalcap = capacity;
            scanner.close();
            boolean[][] visited = new boolean[n][n];
            findPaths(matrix, n, 0, 0, "", capacity,visited,originalcap);

            System.out.println("The available paths are");
            for (String path : availablePaths) {
                System.out.println(path);
            }

            System.out.println("The feasible paths with remaining oxygen levels are");
            for (String path : feasiblePaths) {
                System.out.println(path);
            }
        }

        static void findPaths(int[][] matrix, int n, int x, int y, String path, int oxygen,boolean[][] visited,int originalcap) {
            if (x < 0 || x >= n || y < 0 || y >= n || matrix[x][y] == 0 ) {
                return;
            }

            if ((x == n - 1 && y==n-1) || (x==0 && y==n-1)) {
                availablePaths.add(path);
                if (oxygen >= 0) {
                    feasiblePaths.add(path + " " + oxygen);
                }
                return;
            }
            if(visited[x][y]){
                return;
            }
            visited[x][y] = true;
            if(x<n-1){
                int needed = matrix[x][y] + matrix[x+1][y];
                if(matrix[x][y]==9 && (oxygen-needed)>=0){
                    oxygen = originalcap;
                    findPaths(matrix,n,x+1,y,path + 'D',oxygen,visited,originalcap);
                }else{
                    findPaths(matrix,n,x+1,y,path + 'D',oxygen - needed,visited,originalcap);
                }

            }
            if(y<n-1){
                int needed = matrix[x][y] + matrix[x][y+1];
                if(matrix[x][y]==9 && (oxygen-needed)>=0){
                    oxygen = originalcap;
                    findPaths(matrix,n,x,y+1,path + 'R',oxygen,visited,originalcap);
                }else{
                    findPaths(matrix,n,x,y+1,path + 'R',oxygen - needed,visited,originalcap);
                }

            }
            if(x>0){
                int needed = matrix[x][y] + matrix[x-1][y];
                if(matrix[x][y]==9 && (oxygen-needed)>=0){
                    oxygen = originalcap;
                    findPaths(matrix,n,x-1,y,path + 'U',oxygen,visited,originalcap);
                }else{
                    findPaths(matrix,n,x-1,y,path + 'U',oxygen - needed,visited,originalcap);
                }

            }
            if(y>0){
                int needed = matrix[x][y] + matrix[x][y-1];
                if(matrix[x][y]==9 && (oxygen-needed)>=0){
                    oxygen = originalcap;
                    findPaths(matrix,n,x,y-1,path + 'L',oxygen,visited,originalcap);
                }else{
                    findPaths(matrix,n,x,y-1,path + 'L',oxygen - needed,visited,originalcap);
                }

            }
            visited[x][y] = false;
        }

    }

