package com.leetcode.位运算;

public class Q371 {
    public int getSum(int a, int b) {

        return b == 0 ? a : getSum((a ^ b), (a & b) << 1);
    }
}
