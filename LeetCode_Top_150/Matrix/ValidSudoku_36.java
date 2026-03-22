package LeetCode_Top_150.Matrix;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku_36 {
    public static void main(String[] args) {
        ValidSudoku_36 v = new ValidSudoku_36();
        char[][] board1 = {
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        char[][] board2 = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        char[][] board3 = {
                { '.', '.', '4', '.', '.', '.', '6', '3', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '5', '.', '.', '.', '.', '.', '.', '9', '.' },
                { '.', '.', '.', '5', '6', '.', '.', '.', '.' },
                { '4', '.', '3', '.', '.', '.', '.', '.', '1' },
                { '.', '.', '.', '7', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' } };

        // System.out.println(v.isValidSudoku(board1));
        // System.out.println("--------------------");
        // System.out.println(v.isValidSudoku(board2));
        // System.out.println("--------------------");
        // System.out.println(v.isValidSudoku(board3));

        char[][] board4 = {
                { '.', '.', '4', '.', '.', '.', '6', '3', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '5', '.', '.', '.', '.', '.', '.', '9', '.' },
                { '.', '.', '.', '5', '6', '.', '.', '.', '.' },
                { '4', '.', '3', '.', '.', '.', '.', '.', '1' },
                { '.', '.', '.', '7', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' }
        };
        System.out.println("--------------------");

        System.out.println(v.isValidSudoku(board4));

    }

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            if (!isValidRow(board[i])) {
                return false;
            }

        }

        for (int i = 0; i < board[0].length; i++) {

            if (!isValidCol(board, i)) {
                System.out.println("Invalid col at " + i);

                return false;
            }
            if (!isValidBox(board, i)) {
                System.out.println("Invalid box at " + i);

                return false;
            }
        }

        return true;

    }

    public boolean isValidRow(char[] row) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            if (row[i] == '.')
                continue;
            if (charCount.containsKey(row[i])) {
                System.out.println("Invalid row at " + i + " row [i] " + row[i]);
                return false;
            }

            charCount.put(row[i], 1);
        }
        return true;
    }

    public boolean isValidCol(char[][] board, int col) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == '.')
                continue;

            if (charCount.containsKey(board[i][col])) {
                System.out.println("Invalid col = " + col + " val ,  = " + board[i][col]);
                return false;

            }

            charCount.put(board[i][col], 1);
        }
        return true;
    }

    public boolean isValidBox(char[][] board, int row) {
        if (row % 3 != 0)
            return true;
        Map<Character, Integer> charCount = new HashMap<>();
        int colStart = 0;
        for (int j = colStart; j < 9; j++) {
            if (j % 3 == 0)
                charCount.clear();
            for (int i = row; i < 3; i++) {
                if (board[i][j] == '.')
                    continue;

                if (charCount.containsKey(board[i][j])) {
                    System.out.println("Invalid box at " + i + " [i] " + " [j] " + board[i][j]);
                    return false;

                }
                charCount.put(board[i][j], 1);
            }
        }
        return true;
    }
}
