package com.gmail.imshhui.hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * User: liyulin
 * Date: 2019/9/16
 */
public class WordBreakIITest {
    WordBreakII client = new WordBreakII();

    @Test
    public void wordBreakII() {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> result = client.wordBreak(s, wordDict);
        System.out.println(result);
    }
}
