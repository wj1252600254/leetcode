package com.leetcode.二分法;

public class 二分法 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 6, 6, 6, 8, 13};
        int[] arr = new int[6];
        int res = f11(arr, 1);
        int res1 = f1(arr, -1);
        System.out.println(res1);
        System.out.println(res);
    }

    public static int f1(int[] arr, int target) {
        int l = 0, h = arr.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int f11(int[] arr, int target) {
        int l = 0, h = arr.length;
        while (l <h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] >= target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
