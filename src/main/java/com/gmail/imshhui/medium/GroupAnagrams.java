package com.gmail.imshhui.medium;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 * @see <a href="https://leetcode.com/problems/group-anagrams/"></a>
 * User: liyulin
 * Date: 2019/7/23
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            List<String> temp = map.get(sortedStr);
            if (Objects.isNull(temp)) {
                temp = new ArrayList<>();
            }
            temp.add(str);
            map.put(sortedStr, temp);
        }
        return new ArrayList<>(map.values());
    }
}
