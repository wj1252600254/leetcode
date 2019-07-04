package com.leetcode.位运算;

public class Q190 {
    public static void main(String[] args) {
        int a = 3;
        System.out.println(Integer.toBinaryString(a & 1));
        System.out.println(Integer.toBinaryString(a));
        System.out.println(0b1111);
    }

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (n & 1);
            n >>= 1;
        }
        return ans;
    }
}
