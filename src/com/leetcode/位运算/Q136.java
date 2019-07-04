package com.leetcode.位运算;

public class Q136 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret=ret^n;
        }
        return ret;
    }
}
