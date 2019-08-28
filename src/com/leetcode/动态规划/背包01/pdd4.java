package com.leetcode.动态规划.背包01;

import java.util.Arrays;

public class pdd4 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1}, {2, 1}, {3, 1}, {4, 1}, {5, 1}, {6, 1}, {7, 1}, {8, 1}, {9, 1}, {10, 9}};
    }

    public void f(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        int[] dp = new int[m];
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int weigth = arr[i][1];
            for (int j = sum; j >= 0; j--) {
//                if ()
            }
        }
    }
}
