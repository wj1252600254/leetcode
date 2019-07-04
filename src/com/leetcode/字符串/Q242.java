package com.leetcode.字符串;

public class Q242 {
    public boolean isAnagram(String s, String t) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            a[c - 'a']--;
        }
        for (int temp : a) {
            if (temp != 0) {
                return false;
            }
        }
        return true;
    }
}
