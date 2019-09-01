//package com.test;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class YuanFuDao秋招 {
//    static ArrayList arrayList=new ArrayList();
//
//    public static void main(String[] args) {
//        int[][] aee = new int[][]{{1, 3, 3}, {2, 4, 9}, {8, 9, 2}};
//        int[][] arr = new int[][]{{1, 2}, {1, 2}};
//        f1(aee);
//    }
//
//    public static void f1(int[][] arr) {
//        int k = 1;
//        m = arr.length;
//        n = arr[0].length;
//        int max = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                dfs(arr, i, j, k);
//            }
//        }
//        System.out.print(max);
//    }
//
//
//    private static int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//    private static int m;
//    private static int n;
//
//    public static void f2() {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        String[] strings = str.split(" ");
//        m = Integer.valueOf(strings[0]);
//        n = Integer.valueOf(strings[1]);
//        int k = Integer.valueOf(strings[2]);
//        int[][] arr = new int[m][n];
//        int count = 0;
//        while (scanner.hasNextLine()) {
//            String temp = scanner.nextLine();
//            String[] strings1 = temp.split(" ");
//            for (int i = 0; i < n; i++) {
//                arr[count][i] = Integer.valueOf(strings1[i]);
//            }
//            count++;
//        }
//        int max = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; i < n; j++) {
//                dfs(arr, i, j, k);
//            }
//        }
//        System.out.print(max);
//
//    }
//
//    public static void dfs(int[][] arr, int i, int j, int k) {
//        int cnt=0;
//        for (int[] t : directions) {
//            int nrow = i + t[0];
//            int ncol = j + t[1];
//            if (nrow < 0 || nrow >= m || ncol < 0 || ncol >= n) {
//                continue;
//            }
//            if (arr[nrow][ncol] > arr[i][j]) {
//
//            } else if (arr[nrow][ncol] <= arr[i][j] && k > 0) {
//                return 1 + dfs(arr, nrow, ncol, k - 1);
//            } else {
//                return 0;
//            }
//        }
//        return 0;
//    }
//
//
//    public void f3() {
//        System.out.print(3);
//    }
//}
