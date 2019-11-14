package com.gmail.imshhui.medium;

/**
 * Given a non-negative integer num represented as a string,
 * remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 * @see <a href="https://leetcode.com/problems/remove-k-digits/">402. Remove K Digits</a>
 * User: liyulin
 * Date: 2019/11/14
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        // corner case
        if (num.length() == k) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char cur = num.charAt(i);
            while (k > 0 && res.length() > 0 && res.charAt(res.length() - 1) > cur) {
                res.deleteCharAt(res.length() - 1);
                k--;
            }
            if (res.length() == 0 && cur == '0') {
                continue;
            }
            res.append(cur);
        }
        // corner case: 1111
        while (k > 0 && res.length() > 0) {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }
}
