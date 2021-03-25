package Google.Recursion.Leetcode_37_Sudoku_Solver;

public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null) {
            return;
        }
        helper(board);
    }

    private boolean helper (char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, i, j, ch)){
                            board[i][j] = ch;
                            if (helper(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid (char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch || board[i][col] == ch || board[3 * (row/3)+i/3][3 * (col/3) + i%3] == ch) {
                return false;
            }
        }
        return true;
    }
}
