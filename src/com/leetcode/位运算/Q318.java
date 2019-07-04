package com.leetcode.位运算;

public class Q318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                arr[i] |= 1 << (c - 'a');
            }
        }
        int max=0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] & arr[j] )== 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
