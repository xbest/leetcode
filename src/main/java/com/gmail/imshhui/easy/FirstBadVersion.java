package com.gmail.imshhui.easy;

import com.gmail.imshhui.bean.VersionControl;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 *
 * @see <a href="https://leetcode.com/problems/first-bad-version/">278. First Bad Version</a>
 * User: liyulin
 * Date: 2019/10/14
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid) && !isBadVersion(mid - 1)) {
                return mid;
            } else if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int firstBadVersion1(int n) {
        int left = 1;
        int right = n;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
