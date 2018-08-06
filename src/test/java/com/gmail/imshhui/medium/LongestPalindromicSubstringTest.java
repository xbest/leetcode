package com.gmail.imshhui.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2018/7/30
 */
public class LongestPalindromicSubstringTest {
    private LongestPalindromicSubstring client = new LongestPalindromicSubstring();

    @Test
    public void longestPalindromeTest() {
        Assert.assertEquals("bab", client.longestPalindrome("babad"));
        Assert.assertEquals("bb", client.longestPalindrome("cbbd"));
        Assert.assertEquals("bab", client.longestPalindrome2("babad"));
        Assert.assertEquals("bb", client.longestPalindrome2("cbbd"));
    }
}
