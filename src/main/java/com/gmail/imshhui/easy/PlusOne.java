package com.gmail.imshhui.easy;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * @see <a href="https://leetcode.com/problems/plus-one/"></a>
 * User: liyulin
 * Date: 2019/7/26
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int[] ret = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = i == digits.length - 1 ? digits[i] + 1 : digits[i] + carry;
            carry = sum >= 10 ? 1 : 0;
            digits[i] = sum % 10;
            ret[i + 1] = sum % 10;
        }
        ret[0] = carry;
        return carry == 0 ? digits : ret;
    }
}
