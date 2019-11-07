package com.gmail.imshhui.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * @see <a href="https://leetcode.com/problems/ransom-note/">383. Ransom Note</a>
 * User: liyulin
 * Date: 2019/11/7
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (map.containsKey(c)) {
                int value = map.get(c) - 1;
                if (value == 0) {
                    map.remove(c);
                } else {
                    map.put(c, value);
                }
            }
        }
        return map.isEmpty();
    }
}
