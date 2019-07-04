package com.leetcode.数学;

public class Q168 {
    public String convertToTitle(int n) {
        if (n == 0)
            return "0";
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            //从1开始，所以需要减一
            n--;
            stringBuilder.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return stringBuilder.reverse().toString();
    }
}
