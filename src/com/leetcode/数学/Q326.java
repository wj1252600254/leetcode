package com.leetcode.数学;

public class Q326 {
    /**
     * 用367没有使出来的二分法^_^
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        int l = 1, h = n;
        while (l <= h) {
            int mid = l + (h - l) >>> 1;
            int res = muti3(mid);
            if (res == n) {
                return true;
            } else if (res < n) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return false;
    }

    private int muti3(int num) {
        return num * num * num;
    }
}
