package Graph;

import java.util.*;

/*
 * You are given an image represented by an m x n grid of integers image, where image[i][j] represents 
 * the pixel value of the image. You are also given three integers sr, sc, and color. 
 * Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:

Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, 
either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches 
the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]

Explanation:
From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), 
all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation:
The starting pixel is already colored with 0, which is the same as the target color. 
Therefore, no changes are made to the image.
 */
public class FloodFill {
    public static void main(String[] args) {
        FloodFill sol = new FloodFill();
        System.out.println(
                Arrays.deepToString(sol.floodFill(new int[][] { { 1, 1, 1 }, { 1, 1, 2 }, { 1, 2, 2 } }, 1, 1, 3)));
        System.out.println(
                Arrays.deepToString(sol.floodFill1(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 0 } }, 1, 1, 3)));
    }

    public void dfs(int row, int col, int color, int[][] image, int[][] ans, int start) {
        ans[row][col] = color;
        // visited[row][col] = true;
        int n = image.length;
        int m = image[0].length;
        for (int rowdel = -1; rowdel <= 1; rowdel++) {
            for (int coldel = -1; coldel <= 1; coldel++) {
                if (rowdel == 0 || coldel == 0) {
                    int rowcheck = row + rowdel;
                    int colcheck = col + coldel;
                    if (rowcheck >= 0 && rowcheck < n && colcheck >= 0 && colcheck < m
                            && ans[rowcheck][colcheck] != color && image[rowcheck][colcheck] == start) {
                        dfs(rowcheck, colcheck, color, image, ans, start);
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
        dfs(sr, sc, color, image, ans, start);
        return ans;
    }

    public void bfs(int row, int col, int color, int[][] image, int start) {
        image[row][col] = color;
        // visited[row][col] = true;
        int n = image.length;
        int m = image[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        while (!q.isEmpty()) {
            int a = q.peek().first;
            int b = q.peek().second;
            q.remove();
            for (int rowdel = -1; rowdel <= 1; rowdel++) {
                for (int coldel = -1; coldel <= 1; coldel++) {
                    if (rowdel == 0 || coldel == 0) {
                        int rowcheck = a + rowdel;
                        int colcheck = b + coldel;
                        if (rowcheck >= 0 && rowcheck < n && colcheck >= 0 && colcheck < m
                                && image[rowcheck][colcheck] != color && image[rowcheck][colcheck] == start) {
                            q.add(new Pair(rowcheck, colcheck));
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
        bfs(sr, sc, color, image, start);
        return image;
    }
}
