package com.gmail.imshhui.easy;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 *
 * @see <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">345. Reverse Vowels of a String</a>
 * User: liyulin
 * Date: 2019/11/4
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int low = 0;
        int high = s.length() - 1;
        char temp;
        while (low < high) {
            if (isVowels(chars[low]) && isVowels(chars[high])) {
                temp = chars[low];
                chars[low] = chars[high];
                chars[high] = temp;
                low++;
                high--;
                continue;
            }
            if (!isVowels(chars[low])) {
                low++;
            }
            if (!isVowels(chars[high])) {
                high--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
