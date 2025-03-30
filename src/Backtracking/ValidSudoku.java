package Backtracking;
/*
    * Given a Sudoku board, return true if the board is solvable, otherwise return false.
    * The board is solved in place.
    * Each row, column, and 3x3 subgrid of the board should contain all of the digits from 1-9 without repetition.
    * The board size is 9x9.
    * A valid Sudoku board (partially filled) is not necessarily solvable.
    * Only the filled cells need to be validated according to the mentioned rules.
    * The board is a 2D char array, where the empty cells are filled with the character '.'.
    * You may assume that there will be only one unique solution.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku sol = new ValidSudoku();
        char[][] board = {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        System.out.println(sol.isValidSudoku(board));
    }
        public static boolean isSafe(char[][] board,int row,int col,char num){
            for(int i = 0;i<board.length;i++){
                if(board[row][i]==num || board[i][col]==num){
                    return false;
                }
            }
            int sqrt = (int)Math.sqrt(board.length);
            int rowstart = row - row%sqrt;
            int colstart = col - col%sqrt;
            for(int i = rowstart;i<rowstart+sqrt;i++){
                for(int j = colstart;j<colstart+sqrt;j++){
                    if(board[i][j]==num){
                        return false;
                    }
                }
            }
            return true;
        }
        public static boolean solve(char[][] board,int row,int col){
            if(col==board[0].length){
                row++;
                col = 0;
            }
            if(row==board.length){
                return true;
            }
            char digit = board[row][col];
            if(digit!='.'){
                board[row][col] = '.';
                if(!isSafe(board,row,col,digit)){
                    return false;
                }
                board[row][col] = digit;
            }
            return solve(board,row,col+1);

        }
        public boolean isValidSudoku(char[][] board) {
            return solve(board,0,0);
        }
    }

