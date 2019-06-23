package com.leetcode.双指针;

public class Q633 {
    public boolean judgeSquareSum(int c) {
        int l = 0, h = (int) Math.sqrt(c);
        int res = 0;
        while (l <= h) {
            res = l * l + h * h;
            if (res == c) {
                return true;
            } else if (res < c) {
                l++;
            } else if (res > c) {
                h--;
            }
        }
        return false;
    }
}
