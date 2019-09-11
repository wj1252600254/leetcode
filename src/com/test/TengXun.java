package com.test;

import java.util.Arrays;
import java.util.Scanner;

public class TengXun {
    public static void main(String[] args) {
        testf3(new int[]{7, 2, 4, 6, 5}, 5);
    }
    //******************************************

    public static void f1() {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int n = Integer.valueOf(strings[0]);
        int m = Integer.valueOf(strings[1]);
        int[] boxes = new int[n];
        int[] keys = new int[m];
        String[] strings1 = scanner.nextLine().split(" ");
        String[] strings2 = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            boxes[i] = Integer.valueOf(strings1[i]);
        }
        for (int j = 0; j < m; j++) {
            keys[j] = Integer.valueOf(strings2[j]);
        }
        int[] b = countEvenOdd(boxes);
        int[] k = countEvenOdd(keys);
        int res = 0;
        if (b[0] <= k[1]) {
            res += b[0];
        } else {
            res += k[1];
        }
        if (b[1] <= k[0]) {
            res += b[1];
        } else {
            res += k[0];
        }
        System.out.println(res);
    }

    public static int[] countEvenOdd(int[] arr) {
        int even = 0;
        int odd = 0;
        for (int t : arr) {
            if ((t & 1) == 1) {
                odd++;
            } else {
                even++;
            }
        }
        return new int[]{odd, even};
    }


    public static void testf1() {

    }

    //******************************************


    public static void f2() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] strings = scanner.nextLine().split(" ");
            arr[i][0] = Integer.valueOf(strings[0]);
            arr[i][1] = Integer.valueOf(strings[1]);
        }
        Arrays.sort(arr, (o1, o2) -> o1[1] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += arr[i][0] * i + arr[i][1] * (n - 1 - i);
        }
        System.out.println(res);
    }

    public static void testf2() {

    }


    //******************************************


    public static void f3() {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        int[] arr = new int[num];
        String[] strings = scanner.nextLine().split(" ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.valueOf(strings[i]);
        }
        int max = 0;
        int[] sum = new int[num + 1];
        int suma = 0;
        for (int i = 1; i <= num; i++) {
            suma += arr[i - 1];
            sum[i] = suma;
        }
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, (sum[j] - sum[i]) * arr[i]);
                }
                if (j == num - 1) {
                    max = Math.max(max, (sum[j + 1] - sum[i]) * arr[i]);
                }
            }
        }
        System.out.println(max);

    }

    public static void testf3(int[] arr, int num) {
        int max = 0;
        int[] sum = new int[num + 1];
        int suma = 0;
        for (int i = 1; i <= num; i++) {
            suma += arr[i - 1];
            sum[i] = suma;
        }
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, (sum[j] - sum[i]) * arr[i]);
                    break;
                }
                if (j == num - 1) {
                    max = Math.max(max, (sum[j + 1] - sum[i]) * arr[i]);
                }
            }
        }
        System.out.println(max);
    }


    //******************************************
    public static void f4() {
        System.out.println(5);
    }

    public static void testf4() {

    }

    //******************************************
    public static void f5() {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int t = Integer.valueOf(strings[0]);
        int k = Integer.valueOf(strings[1]);

    }

    public static void testf5() {
        int constant = (int) (Math.pow(10, 9) + 7);
        Scanner scanner = new Scanner(System.in);
        String[] strings1 = scanner.nextLine().split(" ");
        int num = Integer.valueOf(strings1[0]);
        int k = Integer.valueOf(strings1[1]);
        long[] arr = new long[100001];
        for (int i = 1; i < 100001; i++) {
            arr[i] = 1 + getValue(i - k + 1, k);
        }
        System.out.println(Arrays.toString(arr));
        long temp = 0;
        long[] sum = new long[100001];
        for (int i = 1; i < 100001; i++) {
            temp += arr[i];
            sum[i] = temp;
        }
        System.out.println(Arrays.toString(sum));
        for (int i = 0; i < num; i++) {
            String[] strings = scanner.nextLine().split(" ");
            int left = Integer.valueOf(strings[0]);
            int right = Integer.valueOf(strings[1]);
            System.out.println((sum[right] - sum[left - 1]) % constant);
        }
    }

    public static int getValue(int a, int k) {
        int res = a;
        while (a > 0) {
            a -= k;
            res += a;
        }
        return res;
    }


}
