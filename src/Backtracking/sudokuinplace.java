package Backtracking;

public class sudokuinplace {
    public static boolean isSafe(char[][] board,int row,int col,char num){
        for(int i = 0;i<board.length;i++){
            if(board[row][i]==num){
                return false;
            }
            else if(board[i][col]==num){
                return false;
            }
        }
        int sqrt = (int)Math.sqrt(board.length);
        int rowstart = row - row%sqrt;
        int colstart = col -col%sqrt;
        for(int i = rowstart;i<rowstart+sqrt;i++){
            for(int j = colstart;j<colstart+sqrt;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return true;

    }
    public static boolean solveSudoku(char[][] board) {
        int n = board.length;
        int row = -1,col = -1;
        boolean emptyleft = true;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j]=='.'){
                    row=i;
                    col = j;
                    emptyleft= false;
                    break;
                }
            }
            if(emptyleft==false){
                break;
            }
        }
        if(emptyleft==true){
            return true;
        }

        for(char num = '1';num<='9';num++){
            if(isSafe(board,row,col,num)){
                board[row][col]=num;
                if(solveSudoku(board)){
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;

    }
    private static void display(char[][] board) {
        for(char[] row : board) {
            for(char num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board= {
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
        solveSudoku(board);
        if (solveSudoku(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }
    }
}
