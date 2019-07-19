package com.gmail.imshhui.easy;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 *
 * @see <a href="https://leetcode.com/problems/count-and-say/"></a>
 * User: liyulin
 * Date: 2019/7/18
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            char[] chars = countAndSay(--n).toCharArray();
            int count = 0;
            char cur = chars[0];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != cur) {
                    sb.append(count).append(cur);
                    cur = chars[i];
                    count = 1;
                } else {
                    count++;
                }
            }
            sb.append(count > 0 ? count + String.valueOf(cur) : "");
            return sb.toString();
        }
    }
}
