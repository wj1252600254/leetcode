package com.leetcode.数学;

public class Q67 {
    public static void main(String[] args) {
        int a = 0b1100;
        int b = 0b0001;
        System.out.println(Integer.parseInt("111", 2));
        System.out.println(Integer.toBinaryString(a + b));
        System.out.println(0b1111111111111111);
        System.out.println(0b1000000000000000);
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int curry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || curry == 1) {
            if (i >= 0 && a.charAt(i--) == '1') {
                curry++;
            }
            if (j >= 0 && b.charAt(j--) == '1') {
                curry++;
            }
            sb.append(curry % 2);
            curry /= 2;
        }
        return sb.reverse().toString();
    }
}
