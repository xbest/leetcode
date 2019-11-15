package com.gmail.imshhui.easy;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * @see <a href="https://leetcode.com/problems/add-strings/">415. Add Strings</a>
 * User: liyulin
 * Date: 2019/11/15
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            int difference = num2.length() - num1.length();
            for (int i = 0; i < difference; i++) {
                num1 = "0" + num1;
            }
        } else if (num1.length() > num2.length()) {
            int difference = num1.length() - num2.length();
            for (int i = 0; i < difference; i++) {
                num2 = "0" + num2;
            }
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            int b = num2.charAt(i) - '0';
            int sum = a + b + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
