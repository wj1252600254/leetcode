package com.leetcode.二分法;

public class Q278 {
    /**
     * 找出第一个Error的Version
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int l = 1, h = n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (isBadVersion(mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    boolean isBadVersion(int version) {
        return false;
    }

    ;
}
