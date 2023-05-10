package com.gmail.imshhui.medium;

/**
 * 1015. 可被 K 整除的最小整数
 * 给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。
 *
 * 返回 n 的长度。如果不存在这样的 n ，就返回-1。
 *
 * 注意： n 不符合 64 位带符号整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/smallest-integer-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author liyulin
 * @Date 2023/5/10 10:54
 * @Version 1.0
 */
public class SmallestRepunitDivByK {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int i = 1;
        for (int n = 1; n % k != 0; i++) {
            n %= k;
            n = n * 10 + 1;
        }
        return i;
    }

    public static void main(String[] args) {
        SmallestRepunitDivByK smallestRepunitDivByK = new SmallestRepunitDivByK();
        System.out.println(smallestRepunitDivByK.smallestRepunitDivByK(17));
    }
}
