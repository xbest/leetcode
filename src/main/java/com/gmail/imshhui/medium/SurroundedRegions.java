package com.gmail.imshhui.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * @see <a href="https://leetcode.com/problems/surrounded-regions/"></a>
 * User: liyulin
 * Date: 2019/9/16
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            bfs(board, queue, i, 0);
            bfs(board, queue, i, board[0].length - 1);
        }
        for (int j = 0; j < board[0].length; j++) {
            bfs(board, queue, 0, j);
            bfs(board, queue, board.length - 1, j);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '$') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, Queue<Integer> queue, int i, int j) {
        fill(board, queue, i, j);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int x = pos / board[0].length;
            int y = pos % board[0].length;
            fill(board, queue, x - 1, y);
            fill(board, queue, x + 1, y);
            fill(board, queue, x, y - 1);
            fill(board, queue, x, y + 1);
        }
    }

    private void fill(char[][] board, Queue<Integer> queue, int i, int j) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '$';
        // the key logic
        queue.offer(i * board[0].length + j);
    }
}

