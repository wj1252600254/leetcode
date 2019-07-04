package com.leetcode.位运算;

public class Q476 {
    public static void main(String[] args) {
        int num = 0b110001011;
        int mask = num - num & (~num + 1);
        System.out.println(Integer.toBinaryString(mask));
    }

    public int findComplement(int num) {
        if (num == 0)
            return 1;
        int mask = 1;
        mask <<= 30;
        while ((mask & num) == 0) {
            mask >>= 1;
        }
        mask = (mask << 1) - 1;
        return mask ^ num;
    }
}
