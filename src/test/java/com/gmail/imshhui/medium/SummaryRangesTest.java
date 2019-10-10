package com.gmail.imshhui.medium;

import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/10/10
 */
public class SummaryRangesTest {
    SummaryRanges client = new SummaryRanges();
    @Test
    public void summaryRanges() {
        client.summaryRanges(new int[]{0,2,3,4,6,8,9});
    }
}
