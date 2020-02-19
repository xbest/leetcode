package com.gmail.imshhui.easy;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 *
 * Example 1:
 *
 * Input: "USA"
 * Output: True
 *
 *
 * Example 2:
 *
 * Input: "FlaG"
 * Output: False
 *
 *
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 *
 * @see <a href="https://leetcode.com/problems/detect-capital/">520. Detect Capital</a>
 * User: liyulin
 * Date: 2020/2/19
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        boolean upperCase = Character.isUpperCase(word.charAt(0))&&Character.isUpperCase(word.charAt(1));
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (upperCase) {
                if (Character.isLowerCase(c)) {
                    return false;
                }
            } else {
                if (Character.isUpperCase(c)) {
                    return false;
                }
            }

        }
        return true;
    }
}
