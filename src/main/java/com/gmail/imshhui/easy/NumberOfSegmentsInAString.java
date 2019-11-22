package com.gmail.imshhui.easy;

/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 *
 * Input: "Hello, my name is John"
 * Output: 5
 *
 * @see <a href="https://leetcode.com/problems/number-of-segments-in-a-string/">434. Number of Segments in a String</a>
 * User: liyulin
 * Date: 2019/11/22
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        // bad case: "      "
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        s = s.trim();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
        }
        return count;
    }
}
