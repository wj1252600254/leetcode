package com.leetcode.字符串;

public class Q9 {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int mod = 0, reverse = 0;
        while (reverse < x) {
            mod = x % 10;
            reverse = reverse * 10 + mod;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;

    }
}
