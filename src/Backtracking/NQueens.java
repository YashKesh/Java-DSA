package Backtracking;
/*The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
both indicate a queen and an empty space, respectively.

Example 1:

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above*/

import java.util.*;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans  = new ArrayList<>();

        boolean[][] board = new boolean[n][n];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board.length;j++){
                board[i][j]=false;
            }
        }
        queens(board,0,ans);
        return ans;

    }
    static void queens(boolean[][] board,int row,List<List<String>> ans){
        if(row==board.length){
            display(board,ans);
        }
        for(int col = 0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]=true;
                queens(board,row+1,ans);
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
    static void display(boolean[][] board,List<List<String>> ans){
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

    public static void main(String[] args) {
        List<List<String>> ans = new ArrayList<>();
        int n = 4;
        ans = solveNQueens(n);
        System.out.print(ans);


    }
}
