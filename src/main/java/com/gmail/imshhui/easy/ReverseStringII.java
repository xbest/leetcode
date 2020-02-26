package com.gmail.imshhui.easy;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string.
 * If there are less than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 *
 * @see <a href="https://leetcode.com/problems/reverse-string-ii/">541. Reverse String II</a>
 * User: liyulin
 * Date: 2020/2/26
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        int length = s.toCharArray().length;
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i = i + 2 * k) {
            int min = Math.min(i + k, length);
            for (int j = i, m = min - 1; j < m; j++, m--) {
                char temp = chars[j];
                chars[j] = chars[m];
                chars[m] = temp;
            }
        }
        return String.valueOf(chars);
    }
}
