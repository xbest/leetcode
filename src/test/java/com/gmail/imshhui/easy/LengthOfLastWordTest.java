package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/7/24
 */
public class LengthOfLastWordTest {
    LengthOfLastWord client = new LengthOfLastWord();

    @Test
    public void lengthOfLastWord() {
        Assert.assertEquals(1, client.lengthOfLastWord("a"));
        Assert.assertEquals(1, client.lengthOfLastWord("a "));
    }
}
