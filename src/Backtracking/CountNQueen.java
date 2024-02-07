package Backtracking;
import java.util.*;
public class CountNQueen {
    public static void main(String[] args) {
        CountNQueen sol = new CountNQueen();
        System.out.println(sol.totalNQueens(4));
    }
        public int totalNQueens(int n) {
            boolean[][] board = new boolean[n][n];
            for(boolean[] minboard :board){
                Arrays.fill(minboard,false);
            }
            int ans = queens(board,0,n);
            return ans;
        }
        public static int queens(boolean[][] board,int row,int n){
            if(row>=board.length){
                return 1;
            }
            int count=0;
            for(int col= 0;col<n;col++){
                if(isSafe(board,row,col,n)){
                    board[row][col] = true;
                    count+=queens(board,row+1,n);
                    board[row][col] = false;
                }
            }
            return count;
        }
        public static boolean isSafe(boolean[][] board,int row,int col,int n){
             for(int i = 0;i<row;i++){
                 if(board[i][col]){
                     return false;
                 }
             }
             int maxleft = Math.min(row,col);
             for(int i =0 ;i<=maxleft;i++){
                 if(board[row-i][col-i]){
                 return false;
                 }
             }
             int maxright = Math.min(row,board.length-col-1);
             for(int i =0;i<=maxright;i++){
                     if(board[row-i][col+i]){
                         return false;
                     }
             }
             return true;
//            for(int i = 0;i<row;i++){
//                if(board[i][col]){
//                    return false;
//                }
//            }
//            int maxleft = Math.min(row,col);
//            for(int i = 0;i<=maxleft;i++){
//                if(board[row-i][col-i]){
//                    return false;
//                }
//            }
//            int maxright = Math.min(row,board.length-col-1);
//            for(int i = 0;i<=maxright;i++){
//                if(board[row-i][col+i]){
//                    return false;
//                }
//            }
//            return true;
        }
    }

