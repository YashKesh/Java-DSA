package Graph;

import java.util.ArrayList;
import java.util.*;

public class Nearest1 {
    public static void main(String[] args) {
        Nearest1 sol = new Nearest1();
        ArrayList<ArrayList<Integer>> inputMatrix = new ArrayList<>();
        inputMatrix.add(new ArrayList<Integer>() {{add(0); add(1); add(1); add(0);}});
        inputMatrix.add(new ArrayList<Integer>() {{add(1); add(1); add(0); add(0);}});
        inputMatrix.add(new ArrayList<Integer>() {{add(0); add(0); add(1); add(1);}});
        System.out.println(nearest(inputMatrix,3,4));
    }
//    public class Solution {
        public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
            // Write your code here.
            // int n  = mat.length;
            //  int m = mat[0].length;
            int[][] visited = new int[n][m];
            ArrayList<ArrayList<Integer>> dist = new ArrayList<>();
            Queue<Pair3> q = new LinkedList<>();
            for(int i = 0;i<n;i++){
                dist.add(new ArrayList<>());
                for(int j =0;j<m;j++){
                    dist.get(i).add(0);
                    if(mat.get(i).get(j)==1){
                        q.add(new Pair3(i,j,0));
                        visited[i][j] = 1;
                    }
                    else{
                        visited[i][j] = 0;
                    }
                }
            }
            int[] delrow = {1,0,-1,0};
            int[] delcol = {0,-1,0,1};
            while(!q.isEmpty()){
                int row = q.peek().first;
                int col = q.peek().second;
                int steps = q.peek().third;
                q.remove();
                dist.get(row).set(col,steps);
                for(int i=0;i<4;i++){
                    int checkr = row + delrow[i];
                    int checkc = col + delcol[i];
                    if (checkr >= 0 && checkr < n && checkc >= 0 && checkc < m && visited[checkr][checkc] == 0) {
                        visited[checkr][checkc] = 1;
                        q.add(new Pair3(checkr, checkc, steps + 1));
                    }

                }
            }


            return dist;

        }
    }
//}
