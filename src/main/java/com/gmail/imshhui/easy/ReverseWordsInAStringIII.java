package com.gmail.imshhui.easy;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">557. Reverse Words in a String III</a>
 * User: liyulin
 * Date: 2020/2/28
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int prev = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, prev, i - 1);
                prev = i + 1;
            }
            if (i == chars.length - 1) {
                reverse(chars, prev, i);
            }
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j && i >= 0 && j < chars.length) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
