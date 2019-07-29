package com.gmail.imshhui.easy;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * @see <a href="https://leetcode.com/problems/add-binary/"></a>
 * User: liyulin
 * Date: 2019/7/26
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int[] ret = new int[Math.max(a.length(), b.length()) + 1];
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1, k = ret.length - 1; k >= 0; i--, j--, k--) {
            int aInt = i >= 0 ? intC(a.charAt(i)) : 0;
            int bInt = j >= 0 ? intC(b.charAt(j)) : 0;
            int sum = aInt + bInt + carry;
            ret[k] = sum % 2;
            carry = sum >= 2 ? 1 : 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ret.length; i++) {
            if (i == 0 && ret[i] == 0) {

            } else {
                sb.append(ret[i]);
            }
        }
        return sb.toString();
    }

    private int intC(char c) {
        switch (c) {
            case '1':
                return 1;
            case '0':
                return 0;
            default:
                return 0;
        }
    }
}
