package com.gmail.imshhui.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 *
 * Example:
 *
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 *
 * Note:
 *
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 *
 * @see <a href="https://leetcode.com/problems/keyboard-row/">500. Keyboard Row</a>
 * User: liyulin
 * Date: 2020/1/22
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        String firstRow = "QWERTYUIOPqwertyuiop";
        String secondRow = "ASDFGHJKLasdfghjkl";
        String thirdRow = "ZXCVBNMzxcvbnm";
        List<String> list = new ArrayList<>();
        for (String word : words) {
            boolean canAdd = true;
            String temp = "";
            String first = "";
            String second = "";
            String third = "";
            for (char c : word.toCharArray()) {
                first = first + "1";
                second = second + "2";
                third = third + "3";
                String s = String.valueOf(c);
                if (firstRow.contains(s)) {
                    temp = temp + "1";
                }
                if (secondRow.contains(s)) {
                    temp = temp + "2";
                }
                if (thirdRow.contains(s)) {
                    temp = temp + "3";
                }

            }
            if (temp.equals(first) || temp.equals(second) || temp.equals(third)) {
                list.add(word);
            }
        }
        String[] res = new String[list.size()];
        return list.toArray(res);
    }
}
