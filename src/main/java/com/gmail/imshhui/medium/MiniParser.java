package com.gmail.imshhui.medium;

import com.gmail.imshhui.iface.NestedInteger;

/**
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Note: You may assume that the string is well-formed:
 *
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * Example 1:
 *
 * Given s = "324",
 *
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 *
 * Given s = "[123,[456,[789]]]",
 *
 * Return a NestedInteger object containing a nested list with 2 elements:
 *
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 *     i.  An integer containing value 456.
 *     ii. A nested list with one element:
 *          a. An integer containing value 789.
 *
 * @see <a href="https://leetcode.com/problems/mini-parser/">385. Mini Parser</a>
 * User: liyulin
 * Date: 2019/11/7
 */
public class MiniParser {
    public NestedInteger deserialize(String s) {
        NestedInteger res = new NestedInteger();
        if (s == null || s.isEmpty()) {
            return res;
        }
        if (!s.startsWith("[")) {
            res.setInteger(Integer.valueOf(s));
            return res;
        }
        if (s.length() <= 2) {
            return res;
        }

        int start = 1;
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count == 0 && (c == ',' || i == s.length() - 1)) {
                res.add(deserialize(s.substring(start, i)));
            } else if (c == '[') {
                count++;
            } else if (c == ']') {
                count--;
            }
        }
        return res;
    }
}


