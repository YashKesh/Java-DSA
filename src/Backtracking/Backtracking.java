package Backtracking;//import java.awt.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.List;

public class Backtracking {
    static List<List<String>> ans  = new ArrayList<>();

    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board.length;j++){
                board[i][j]=false;
            }
        }
        queens(board,0);
        System.out.print(ans);
    }

     static void queens(boolean[][] board,int row){
         if(row==board.length){
             display(board);
         }
         for(int col = 0;col<board.length;col++){
             if(isSafe(board,row,col)){
                 board[row][col]=true;
                 queens(board,row+1);
                 board[row][col]=false;
             }
         }
     }
     static boolean isSafe(boolean[][] board,int row ,int col){
         for(int i = 0;i<row;i++){
             if(board[i][col]){
                 return false;
             }
         }
         int maxleft = Math.min(row,col);
         for(int i = 0;i<=maxleft;i++){
             if(board[row-i][col-i]){
                 return false;
             }
         }
         int maxright = Math.min(row,board.length-col-1);
         for(int i = 0;i<=maxright;i++){
             if(board[row-i][col+i]){
                 return false;
             }
         }
         return true;

     }
     static void display(boolean[][] board){

         List<String> myans = new ArrayList<>();

         for(boolean[] row :board){
             StringBuilder p = new StringBuilder();
             for(boolean element:row){
                 if(element){
                     p.append('Q');
                 }
                 else{
                     p.append('.');
                 }
             }
             myans.add(p.toString());
         }
         ans.add(myans);
     }
}
