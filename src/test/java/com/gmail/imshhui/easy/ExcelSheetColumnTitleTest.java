package com.gmail.imshhui.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/9/23
 */
public class ExcelSheetColumnTitleTest {
    ExcelSheetColumnTitle client = new ExcelSheetColumnTitle();
    @Test
    public void convertToTitle() {
//        Assert.assertEquals("A",client.convertToTitle(1));
        Assert.assertEquals("AB",client.convertToTitle(28));
//        Assert.assertEquals("ZY",client.convertToTitle(701));
    }
}
