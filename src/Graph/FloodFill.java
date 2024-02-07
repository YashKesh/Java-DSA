package Graph;
import java.util.*;
public class FloodFill {
    public static void main(String[] args) {
        FloodFill sol = new FloodFill();
        System.out.println(Arrays.deepToString(sol.floodFill(new int[][]{{1, 1, 1}, {1, 1, 2}, {1, 2, 2}}, 1, 1, 3)));
        System.out.println(Arrays.deepToString(sol.floodFill1(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 0}}, 1, 1, 3)));
    }
    public void dfs(int row,int col,int color,int[][] image,int[][] ans,int start){
        ans[row][col] = color;
        // visited[row][col] = true;
        int n = image.length;
        int m = image[0].length;
        for(int rowdel = -1 ;rowdel<=1;rowdel++){
            for(int coldel = -1;coldel<=1;coldel++){
                if(rowdel==0 || coldel==0){
                    int rowcheck = row + rowdel;
                    int colcheck = col + coldel;
                    if(rowcheck>=0 && rowcheck<n && colcheck>=0 && colcheck<m && ans[rowcheck][colcheck]!=color &&  image[rowcheck][colcheck]==start){
                        dfs(rowcheck,colcheck,color,image,ans,start);
                    }
                }
            }
        }
    }
    public int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int start = image[sr][sc];
        int[][] ans = image;
        // boolean[][] visited = new boolean[n][m];
        dfs(sr,sc,color,image,ans,start);
        return ans;
    }
        public void bfs(int row,int col,int color,int[][] image,int start){
            image[row][col] = color;
            // visited[row][col] = true;
            int n = image.length;
            int m = image[0].length;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(row,col));
            while(!q.isEmpty()){
                int a = q.peek().first;
                int b = q.peek().second;
                q.remove();
                for(int rowdel = -1 ;rowdel<=1;rowdel++){
                    for(int coldel = -1;coldel<=1;coldel++){
                        if(rowdel==0 || coldel==0){
                            int rowcheck = a + rowdel;
                            int colcheck = b + coldel;
                            if(rowcheck>=0 && rowcheck<n && colcheck>=0 && colcheck<m && image[rowcheck][colcheck]!=color &&  image[rowcheck][colcheck]==start){
                                q.add(new Pair(rowcheck,colcheck));
                                image[rowcheck][colcheck] = color;

                            }
                        }
                    }
                }
            }
        }
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int n = image.length;
            int m = image[0].length;
            int start = image[sr][sc];
            // boolean[][] visited = new boolean[n][m];
            bfs(sr,sc,color,image,start);
            return image;
        }
    }

