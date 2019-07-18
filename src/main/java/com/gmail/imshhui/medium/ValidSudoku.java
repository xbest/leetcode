package com.gmail.imshhui.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 * <p>
 *
 * @see <a href="https://leetcode.com/problems/valid-sudoku/"></a>
 * User: liyulin
 * Date: 2019/7/18
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValid(board, i, true)) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (!isValid(board, j, false)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSubBox(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, boolean row) {
        Map<String, String> map = new HashMap<>();
        for (int j = 0; j < 9; j++) {
            if (!isValidChar(map, row ? board[i][j] : board[j][i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidSubBox(char[][] board, int i, int j) {
        int iLength = i + 3;
        int jLength = j + 3;
        Map<String, String> map = new HashMap<>();
        for (; i < iLength; i++) {
            // init index k per time
            int k = j;
            for (; k < jLength; k++) {
                if (!isValidChar(map, board[i][k])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidChar(Map<String, String> map, char c) {
        String charStr = String.valueOf(c);
        if (!charStr.equals(".") && map.containsKey(charStr)) {
            return false;
        }
        map.put(charStr, charStr);
        return true;
    }
}
