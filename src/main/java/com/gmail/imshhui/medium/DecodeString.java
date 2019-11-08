package com.gmail.imshhui.medium;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 * @see <a href="https://leetcode.com/problems/decode-string/">394. Decode String</a>
 * User: liyulin
 * Date: 2019/11/8
 */
public class DecodeString {
    public String decodeString(String s) {
        int idx = 0;
        String res = "";
        Stack<String> resStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (c == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (c == ']') {
                int count = countStack.pop();
                StringBuilder temp = new StringBuilder(resStack.pop());
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                res = res + c;
                idx++;
            }
        }
        return res;
    }
}
