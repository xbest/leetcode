package com.gmail.imshhui.easy;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 *
 * @see <a href="https://leetcode.com/problems/excel-sheet-column-number/"></a>
 * User: liyulin
 * Date: 2019/9/23
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        char[] chars = new StringBuilder(s).reverse().toString().toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            res = res + (chars[i] - 'A' + 1) * (int) Math.pow(26, i);
        }
        return res;
    }
}
