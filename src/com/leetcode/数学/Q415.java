package com.leetcode.数学;

public class Q415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int curry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || curry == 1) {
            int a = 0, b = 0, sum = 0;
            if (i >= 0)
                a = num1.charAt(i--) - '0';
            if (j >= 0)
                b = num2.charAt(j--) - '0';
            sum = a + b + curry;
            sb.append(sum % 10);
            curry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
