package com.leetcode.位运算;

public class Q461 {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while (z != 0) {
            z = z & (z - 1);
            cnt++;
        }
        return cnt;
    }
}
