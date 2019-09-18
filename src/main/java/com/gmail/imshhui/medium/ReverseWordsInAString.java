package com.gmail.imshhui.medium;

/**
 * Given an input string, reverse the string word by word.
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Follow up:
 *
 * For C programmers, try to solve it in-place in O(1) extra space.
 *
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string/"></a>
 * User: liyulin
 * Date: 2019/9/18
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            String temp = strings[i].trim();
            if (!" ".equals(temp)) {
                sb.append(temp).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
