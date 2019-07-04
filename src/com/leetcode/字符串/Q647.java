package com.leetcode.字符串;

public class Q647 {
    private int cnt = 0;

    public int countSubstrings(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            count(s, i, i + 1);
            count(s, i, i + 1);
        }
        return cnt;
    }

    private void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }
}
