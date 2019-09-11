package com.test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PDD {
    public static void main(String[] args) {
        testf3(new int[]{2,3},2);
    }
    //******************************************

    public static void f1() {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split(";");
        int N = Integer.valueOf(text[1]);
        PriorityQueue<Integer> even = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> odd = new PriorityQueue<>((o1, o2) -> o2 - o1);
        String[] strings = text[0].split(",");
        int len = strings.length;
        for (int i = 0; i < len; i++) {
            int tem = Integer.valueOf(strings[i]);
            if ((tem & 1) == 1) {
                odd.add(tem);
            } else {
                even.add(tem);
            }
        }
        for (int i = 0; i < N; i++) {
            if (!even.isEmpty()) {
                if (i != N - 1) {
                    System.out.print(even.poll() + ",");
                } else {
                    System.out.print(even.poll());
                }
            } else {
                if (i != N - 1) {
                    System.out.print(odd.poll() + ",");
                } else {
                    System.out.print(odd.poll());
                }
            }
        }


    }

    public static void testf1() {

    }

    //******************************************


    public static void f2() {

    }

    public static void testf2() {
        System.out.println("{\n" +
                "d d l \n" +
                "d d r \n" +
                "}\n" +
                "{\n" +
                "l l l \n" +
                "r l l \n" +
                "}\n" +
                "{\n" +
                "}");
    }


    //******************************************


    public static void f3() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String[] strings = scanner.nextLine().split(" ");
        int[] nums = new int[n];
        int total=1;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(strings[i]);
            total *= nums[i];
        }
        Arrays.sort(nums);
        double res = 0.0;
        int maxValue = nums[n - 1];
        while (maxValue >= 1) {
            int cnt=1;
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] == maxValue) {
                    cnt++;
                }else {
                    break;
                }
            }
            int pos=1;
            for (int i = n - 1; i >= 0; i--) {
                if (cnt-- != 0) {
                    pos *= nums[i];
                    nums[i]--;
                } else {
                    pos *= nums[i];
                }
            }
            res +=(1-(double)pos/total)*maxValue;
            maxValue--;
        }
        System.out.printf("%.2f",res);
    }

    public static void testf3(int[] nums,int n) {
        int total=4;
        Arrays.sort(nums);
        double res = 0.0;
        int maxValue = nums[n - 1];
        while (maxValue >= 1) {
            int cnt=1;
            for (int i = n - 1; i > 0; i--) {
                if (nums[i] == maxValue) {
                    cnt++;
                }else {
                    break;
                }
            }
            int pos=1;
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] == 1) {
                    maxValue--;
                    break;
                }
                if (cnt-- != 0) {
                    pos *= nums[i]-1;
                    nums[i]--;
                } else {
                    pos *= nums[i];
                }
            }
            res +=(1-(double)pos/total)*maxValue;
            maxValue--;
        }
        res += (double) 1 / total;
        System.out.printf("%.2f",res);

    }


    //******************************************
    public static void f4() {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int n = Integer.valueOf(strings[0]); //col
        int m = Integer.valueOf(strings[1]); //row
        int k = Integer.valueOf(strings[2]);
        k = m * n - k + 1;
        int[][] arr = new int[m][n];
        for (int i = 0, cnt = 1; i < m; i++, cnt++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (j + 1) * cnt;
            }
        }
        int max = arr[m - 1][n - 1];
        int min = arr[0][0];
        while (min < max) {
            int mid = min + (max - min) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && arr[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        System.out.println(min);
    }

    public static void testf4() {

    }

}
