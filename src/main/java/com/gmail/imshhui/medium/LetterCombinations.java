package com.gmail.imshhui.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * <p>
 * User: liyulin
 * Date: 2018/12/17
 */
public class LetterCombinations {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        combination("", digits, 0, result);
        return result;
    }

    private void combination(String prefix, String digits, int offset, List<String> result) {
        if (offset >= digits.length()) {
            result.add(prefix);
            return;
        }
        String letters = KEYS[digits.charAt(offset) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, result);
        }
    }

}
