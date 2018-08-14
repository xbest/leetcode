package com.gmail.imshhui.medium;

import java.nio.charset.Charset;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int length = s.length();
        char[] chars = s.toCharArray();
        char[][] printChars = new char[numRows][length];
        int row = 0, column = 0;
        boolean goingdown = true;
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < length; i++) {
            if (goingdown) {
                printChars[row][column] = chars[i];
                row++;
            }
            if (!goingdown) {
                printChars[row][column] = chars[i];
                row--;
                column++;
            }
            if (row == numRows-1) {
                goingdown = false;
            }
            if (row == 0) {
                goingdown = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < length; j++) {
                char c = printChars[i][j];
                if (c != 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
