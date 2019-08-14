package com.gmail.imshhui.medium;

import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/8/14
 */
public class RestoreIPAddressesTest {
    RestoreIPAddresses client = new RestoreIPAddresses();
    @Test
    public void restoreIpAddresses() {
        String s = "25525511135";
        client.restoreIpAddresses(s);
    }
}
