package com.test;

import java.util.Scanner;

public class DIDI {
    public static void main(String[] args) {

    }

    public static void f1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] cnt = new int[n + 1];
        boolean[] mark = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            mark[a] = true;
            mark[b] = true;
            cnt[a]++;
            cnt[b]++;
        }
        int c = 0;
        for (boolean t : mark) {
            if (t) {
                c++;
            }
        }
        c -= 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (mark[i]) {
                max = Math.max(max, c - cnt[i]);
            }
        }
        System.out.println((max + (n - c + 1) / 2) * 2);
    }

    public static void f2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += scanner.nextInt();
            arr[i] = sum;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n - m + 1; i++) {
            for (int j = i + m; j <= n; j++) {
                if (arr[j] - arr[i] < min) {
                    min = arr[j] - arr[i];
                }
            }
        }
        System.out.println(min);
    }

    public static void f3() {
        Scanner scanner = new Scanner(System.in);
    }


    public class Main {

    }

}
