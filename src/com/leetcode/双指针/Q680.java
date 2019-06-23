package com.leetcode.双指针;

public class Q680 {
    public boolean validPalindrome(String s) {
        int l = 0, h = s.length() - 1;
        while (l < h) {
            if (s.charAt(l) != s.charAt(h)) {
                return idValid(s, l + 1, h) || idValid(s, l, h - 1);
            }
            l++;
            h--;
        }
        return true;
    }

    private boolean idValid(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
