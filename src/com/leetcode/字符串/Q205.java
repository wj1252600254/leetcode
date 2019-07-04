package com.leetcode.字符串;

public class Q205 {
    public static void main(String[] args) {
        new Q205().isIsomorphic("aa", "ab");
    }

    public boolean isIsomorphic(String s, String t) {
        int[] positionS = new int[256];
        int[] positionT = new int[256];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if (positionS[si] != positionT[ti]) {
                return false;
            }
            //放的是出现的位置,如果不加1的话，第一次存储的数字，那么第二次出现还是为0
            positionS[si] = i + 1;
            positionT[ti] = i + 1;
        }
        return true;
    }
}
