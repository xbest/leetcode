package com.gmail.imshhui.medium;

/**
 * Additive number is a string whose digits can form additive sequence.
 *
 * A valid additive sequence should contain at least three numbers.
 * Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 *
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 *
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 *
 * Example 1:
 *
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 *              1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * Example 2:
 *
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199.
 *              1 + 99 = 100, 99 + 100 = 199
 *
 * Constraints:
 *
 * num consists only of digits '0'-'9'.
 * 1 <= num.length <= 35
 * Follow up:
 * How would you handle overflow for very large input integers?
 *
 * @see <a href="https://leetcode.com/problems/additive-number/">306. Additive Number</a>
 * User: liyulin
 * Date: 2019/10/16
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length() / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                continue;
            }
            for (int j = i + 1; j < num.length(); j++) {
                if (num.charAt(i) == '0' && j - i > 1) {
                    continue;
                }
                if (dfs(num, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(String num, int i, int j, int k) {
        long add1 = Long.parseLong(num.substring(i, j));
        long add2 = Long.parseLong(num.substring(j, k));
        String addition = String.valueOf(add1 + add2);
        if (!num.substring(k).startsWith(addition)) {
            return false;
        }
        if (k + addition.length() == num.length()) {
            return true;
        }
        return dfs(num, j, k, k + addition.length());
    }
}
