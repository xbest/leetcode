package com.gmail.imshhui.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11),
 * and the 6 LEDs on the bottom represent the minutes (0-59).
 *
 * Each LED represents a zero or one, with the least significant bit on the right.
 *
 *
 * For example, the above binary watch reads "3:25".
 *
 * Given a non-negative integer n which represents the number of LEDs that are currently on,
 * return all possible times the watch could represent.
 *
 * Example:
 *
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid,
 * it should be "10:02".
 *
 * @see <a href="https://leetcode.com/problems/binary-watch/">401. Binary Watch</a>
 * User: liyulin
 * Date: 2019/11/14
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        // hours: 1, 2, 4, 8
        int[] hours = new int[]{1, 2, 4, 8};
        // minutes: 1, 2, 4, 8, 16, 32
        int[] minutes = new int[]{1, 2, 4, 8, 16, 32};
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            List<Integer> hoursList = generateDigits(hours, i);
            List<Integer> minutesList = generateDigits(minutes, num - i);
            for (Integer hour : hoursList) {
                if (hour >= 12) {
                    continue;
                }
                for (Integer minute : minutesList) {
                    if (minute >= 60) {
                        continue;
                    }
                    res.add(hour + ":" + (minute < 10 ? "0" + minute : minute));
                }
            }
        }
        return res;
    }

    private List<Integer> generateDigits(int[] digits, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitsHelper(res, digits, count, 0, 0);
        return res;
    }

    private void generateDigitsHelper(List<Integer> res, int[] digits, int count, int pos, int sum) {
        if (count == 0) {
            res.add(sum);
            return;
        }
        for (int i = pos; i < digits.length; i++) {
            generateDigitsHelper(res, digits, count - 1, i + 1, sum + digits[i]);
        }
    }
}
