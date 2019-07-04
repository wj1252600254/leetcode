package com.leetcode.位运算;

public class Q338 {
    public int[] countBits(int num) {
        int[] ans = new int[num];
        for (int i = 1; i < num; i++) {
            ans[i]=ans[i&(i-1)]+1;
        }
        return ans;
    }
}
