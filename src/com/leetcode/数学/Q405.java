package com.leetcode.数学;

public class Q405 {
    public static void main(String[] args) {
        int a = 32;
        System.out.println(a & 0b1111);
        System.out.println(a >>>= 4 & 0b1111);
        System.out.println(0b1111);
    }

    // 0000 0000 0010 0000  & 1111
    public String toHex(int num) {
        if (num == 0)
            return "0";
        char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            //转换成补码后，就不存在正负
            sb.append(map[num & 0b1111]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
