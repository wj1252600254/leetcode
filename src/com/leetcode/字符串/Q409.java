package com.leetcode.字符串;

public class Q409 {
    public int longestPalindrome(String s) {
        int[] a = new int[256];
        //a-z可以使用26
        for (char c : s.toCharArray()) {
            a[c]++;
        }
        int len = 0;
        for (int t : a) {
            len += t / 2 * 2;
        }
        if (len < s.length())
            len++;
        return len;
    }
}
