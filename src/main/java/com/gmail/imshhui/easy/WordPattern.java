package com.gmail.imshhui.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters,
 * and str contains lowercase letters that may be separated by a single space.
 *
 * @see <a href="https://leetcode.com/problems/word-pattern/">290. Word Pattern</a>
 * User: liyulin
 * Date: 2019/10/15
 */
public class WordPattern {
    public boolean wordPattern1(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i])) {
                    return false;
                }
            } else if (map.containsValue(words[i])) {
                return false;
            }
            map.put(c, words[i]);
        }
        return true;
    }

    public boolean wordPattern(String pattern, String str) {
        Map map = new HashMap<>();
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        // bad case: if int i = 0 instead of Integer i = 0 in the iterative for
        // because of autoboxing, @see <code>Integer.valueOf()</code>
        //"ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd"
        //"s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"
        for (Integer i = 0; i < pattern.length(); i++) {
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }
}
