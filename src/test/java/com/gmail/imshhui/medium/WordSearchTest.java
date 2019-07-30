package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/30
 */
public class WordSearchTest {
    WordSearch client = new WordSearch();

    @Test
    public void exist() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Assert.assertEquals(true, client.exist(board, "ABCCED"));
        char[][] board1 = {{'a', 'a'}};
        Assert.assertEquals(false, client.exist(board1, "aaa"));

        char[][] board2 = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        Assert.assertEquals(true, client.exist(board2, "AAB"));

        char[][] board3 = {{'a'}};
        Assert.assertEquals(true, client.exist(board3, "a"));
    }
}
