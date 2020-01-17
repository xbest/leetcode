package com.gmail.imshhui.easy;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 2^31.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 *
 * @see <a href="https://leetcode.com/problems/hamming-distance/"></a>
 * User: liyulin
 * Date: 2020/1/17
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance1(int x, int y) {
        int res = x ^ y;
        int count = 0;
        while (res != 0) {
            count++;
            res = (res - 1) & res;
        }
        return count;
    }

    public int hammingDistance2(int x, int y) {
        int res = x ^ y;
        int count = 0;
        while (res != 0) {
            if ((res & 1) == 1) {
                count++;
            }
            // only for positive
            res = res >> 1;
        }
        return count;
    }
}
