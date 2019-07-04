package com.leetcode.矩阵与数组;

public class Q283 {
    public static void main(String[] args) {
        int i = 0;
        int[] a = new int[2];
        a[i++] = 100;
        System.out.println(a[1]);
        System.out.println(a[0]);
    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
