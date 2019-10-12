package com.gmail.imshhui.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * @see <a href="https://leetcode.com/problems/valid-anagram/">242. Valid Anagram</a>
 * User: liyulin
 * Date: 2019/10/12
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = 0;
            if (map.containsKey(c)) {
                value = map.get(c);
            }
            map.put(c, value + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                int value = map.get(c);
                if (value - 1 == 0) {
                    map.remove(c);
                } else {
                    map.put(c, value - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}
