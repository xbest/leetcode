package com.gmail.imshhui.medium;

/**
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 *
 * For 1-byte character, the first bit is a 0, followed by its unicode code.
 * For n-bytes character, the first n-bits are all one's, the n+1 bit is 0,
 * followed by n-1 bytes with most significant 2 bits being 10.
 * This is how the UTF-8 encoding would work:
 *
 *    Char. number range  |        UTF-8 octet sequence
 *       (hexadecimal)    |              (binary)
 *    --------------------+---------------------------------------------
 *    0000 0000-0000 007F | 0xxxxxxx
 *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
 *
 * Note:
 * The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data.
 * This means each integer represents only 1 byte of data.
 *
 * Example 1:
 *
 * data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
 *
 * Return true.
 * It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
 * Example 2:
 *
 * data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
 *
 * Return false.
 * The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
 * The next byte is a continuation byte which starts with 10 and that's correct.
 * But the second continuation byte does not start with 10, so it is invalid.
 *
 * @see <a href="https://leetcode.com/problems/utf-8-validation/">393. UTF-8 Validation</a>
 * User: liyulin
 * Date: 2019/11/8
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        // 0xxxxxxx, 1 byte,  192(11000000), 128(10000000)
        // 110xxxxx, 2 bytes, 224(11100000), 192(11000000)
        // 1110xxxx, 3 bytes, 240(11110000), 224(11100000)
        // 11110xxx, 4 bytes, 248(11111000), 240(11110000)
        if (data == null || data.length == 0) {
            return false;
        }
        int count = 0;
        for (int num : data) {
            if (count == 0) {
                if ((num & 128) == 0) {
                    count = 0;
                } else if ((num & 224) == 192) {
                    count = 1;
                } else if ((num & 240) == 224) {
                    count = 2;
                } else if ((num & 248) == 240) {
                    count = 3;
                } else {
                    return false;
                }
            } else {
                if ((num & 192) != 128) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }
}
