package com.leetcode;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //先在常量池中找"11"
        //然后在堆中找"11"引用
        String a = new String("1") + new String("1");
//        String c = new String("11");
        a.intern();
        String b = "11";
        System.out.println(a == b);
        int[] arr = new int[2];
        int i=0;
        arr[i++] = 100;
        System.out.println(Arrays.toString(arr));
    }
}
