package Arrays;
import  java.util.*;
public class  SpiralMatrix {
    public static void main(String[] args) {
     SpiralMatrix sol = new SpiralMatrix();
        System.out.println(sol.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int rows = matrix.length;
            int columns = matrix[0].length;
            int left = 0;
            int right = columns-1;
            int up = 0;
            int down = rows-1;
            while(ans.size()<rows*columns){
                for(int col = left;col<=right;col++){
                    ans.add(matrix[up][col]);
                }
                for(int row  = up+1;row<=down;row++){
                    ans.add(matrix[row][right]);
                }
                if(up!=down){
                    for(int col = right-1;col>=left;col--){
                        ans.add(matrix[down][col]);
                    }

                }
                if(left!=right){
                    for(int row=down-1;row>up;row--){
                        ans.add(matrix[row][left]);
                    }
                }
                left++;
                right--;
                up++;
                down--;
            }
            return ans;
        }
    }

