package com.test;

import java.util.*;

public class TengXun3 {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(4);
        priorityQueue.add(1);
        priorityQueue.add(2);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue);

    }

    public static void f1() {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            int len = Integer.valueOf(scanner.nextLine());
            ;
            String num = scanner.nextLine();
            if (len < 11) {
                System.out.println("NO");
                continue;
            }
            int index = num.indexOf("8");
            if (index == -1) {
                System.out.println("NO");
                continue;
            }
            if (len - index < 11) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    public static void f2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            for (int j = 0; j < x; j++) {
                priorityQueue.add(y);
            }
        }
        Integer[] aa = priorityQueue.toArray(new Integer[0]);
        int len = aa.length;
        int mim = Integer.MIN_VALUE;
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            mim = Math.max(mim, aa[i]+aa[j]);
        }
        System.out.println(mim);
    }

    public static void f3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int len = scanner.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = scanner.nextInt();
            }
            Arrays.sort(arr);
            int cnt = len / 4;
            int mod = len % 4;
            int fir = 0;
            int sec = 0;
            int l = 0;
            int cut = cnt;
            while (cut-- > 0) {
                fir += arr[l] + arr[len - 1 - l];
                l++;
                sec += arr[l] + arr[len - 1 - l];
            }
            if (mod == 0) {
                if (fir <= sec) {
                    System.out.println(fir + " " + sec);
                } else {
                    System.out.println(sec + " " + fir);
                }
            } else if (mod == 1) {
                fir += arr[cnt * 2];
                if (fir <= sec) {
                    System.out.println(fir + " " + sec);
                } else {
                    System.out.println(sec + " " + fir);
                }
            } else if (mod == 2) {
                if (fir <= sec) {
                    fir += arr[2 * cnt + 1];
                    sec += arr[2 * cnt];
                } else {
                    sec += arr[2 * cnt + 1];
                    fir += arr[2 * cnt];
                }
                if (fir <= sec) {
                    System.out.println(fir + " " + sec);
                } else {
                    System.out.println(sec + " " + fir);
                }
            } else {
                fir += arr[2 * cnt + 2];
                sec += arr[2 * cnt];
                if (fir <= sec) {
                    fir += arr[2 * cnt + 1];
                } else {
                    sec += arr[2 * cnt + 1];
                }
                if (fir <= sec) {
                    System.out.println(fir + " " + sec);
                } else {
                    System.out.println(sec + " " + fir);
                }
            }
        }
    }

    public static void f4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        Collections.sort(list);
        System.out.println(list);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int t = list.get(i + 1) - list.get(i);
            if (t > 0 && cnt < k) {
                System.out.println(t);
                cnt++;
            }
        }
        if (cnt < k) {
            for (int i = cnt; i < k; i++) {
                System.out.println(0);
            }
        }
    }


    public static void f5() {
        Scanner scanner = new Scanner(System.in);
    }
}
