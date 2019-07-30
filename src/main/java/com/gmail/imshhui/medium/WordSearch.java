package com.gmail.imshhui.medium;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * @see <a href="https://leetcode.com/problems/word-search/"></a>
 * User: liyulin
 * Date: 2019/7/30
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrace(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrace(char[][] board, int i, int j, String word, int index) {
        int rows = board.length;
        int cols = board[0].length;
        if (index == word.length()) {
            return true;
        }
        char c = word.charAt(index);
        if (i < 0 || i > rows - 1 || j < 0 || j > cols - 1 || board[i][j] != c) {
            return false;
        }
        board[i][j] = '*';
        boolean result = backtrace(board, i + 1, j, word, index + 1)
                || backtrace(board, i - 1, j, word, index + 1)
                || backtrace(board, i, j + 1, word, index + 1)
                || backtrace(board, i, j - 1, word, index + 1);
        //recover the char
        board[i][j] = c;
        return result;
    }
}
