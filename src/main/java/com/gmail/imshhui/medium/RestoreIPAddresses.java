package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <p>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 *
 * @see <a href="https://leetcode.com/problems/restore-ip-addresses/"></a>
 * User: liyulin
 * Date: 2019/8/14
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        backtrace(ret, "", s, 0);
        return ret;
    }

    private void backtrace(List<String> ret, String path, String s, int k) {
        if (s.isEmpty() || k == 4) {
            if (s.isEmpty() && k == 4) {
                ret.add(path.substring(1));// remove the first dot
            }
            return;
        }
        // i < s.length() - 1 is wrong, since substring will exclude the i.
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) {
            String part = s.substring(0, i);
            if (Integer.valueOf(part) <= 255) {
                backtrace(ret, path + "." + part, s.substring(i), k + 1);
            }
        }
    }
}
