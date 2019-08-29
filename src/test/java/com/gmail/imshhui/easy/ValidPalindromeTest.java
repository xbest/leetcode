package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/8/29
 */
public class ValidPalindromeTest {
    ValidPalindrome client = new ValidPalindrome();

    @Test
    public void isPalindrome() {
        Assert.assertFalse(client.isPalindrome("ab"));
    }
}
