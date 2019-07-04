package com.leetcode.字符串;

public class Q696 {
    public int countBinarySubstrings(String s) {
        int prelen = 0, curlen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curlen++;
            } else {
                prelen = curlen;
                curlen = 1;
            }
            if (prelen >= curlen) {
                count++;
            }
        }
        return count;
    }
}
