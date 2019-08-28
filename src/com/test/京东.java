package com.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 京东 {
    public static void main(String[] args) {
        f1();
    }

    public static void f1() {
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.nextLine().split(" ");
        int num = Integer.valueOf(a[0]);
        int re = Integer.valueOf(a[1]);
        Set<Integer>[] sets = new Set[2 * num + 1];
        for (int i = 1; i <= 2 * num; i++) {
            sets[i] = new HashSet<>();
        }
        for (int i = 0; i < num; i++) {
            String[] strings = scanner.nextLine().split(" ");
            int fir = Integer.valueOf(strings[0]);
            int sec = Integer.valueOf(strings[1]);
            sets[fir].add(sec);
            sets[sec].add(fir);
        }

    }
}
