package com.leetcode.数学;

public class Q507 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        stringBuilder.append(2);
        System.out.println(stringBuilder.toString());
    }

    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        boolean isNagtice = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (num != 0)
            sb.append(num);
        String ret = sb.reverse().toString();
        return isNagtice ? "-" + sb.toString() : sb.toString();
    }
}
