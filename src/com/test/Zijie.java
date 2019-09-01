package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Zijie {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        System.out.println(linkedList.getLast());
//        System.out.println(linke);
    }

    public static void f1() {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(Integer.valueOf(scanner.nextLine()));
        int[] time = new int[num];
        Arrays.sort(time);
        for (int i = 0; i < num; i++) {
            String[] strings = scanner.nextLine().split(" ");
            time[i] = Integer.valueOf(strings[0]) * 60 + Integer.valueOf(strings[1]);
        }
        int X = Integer.valueOf(scanner.nextLine());
        String[] strings = scanner.nextLine().split(" ");
        int end = Integer.valueOf(strings[0]) * 60 + Integer.valueOf(strings[1]);
        boolean isOk = true;
        int pre = time[0];
        for (int i = 1; i < num && isOk; i++) {
            if (time[i] + X <= end) {
                pre = time[i];
                continue;
            }
            isOk = false;
        }
        System.out.println(pre / 60 + " " + pre % 60);
    }

    public static void f2() {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int N = Integer.valueOf(strings[0]);
        int K = Integer.valueOf(strings[1]);
        String num = scanner.nextLine();
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        int mark = num.charAt(0) - '0';
        queue.add(mark);
        stringBuilder.append(mark);
        for (int i = 1; i < N; i++) {
            if (i >= K) {
                int temp = queue.removeFirst();
                mark ^= temp;
                int t = num.charAt(i) - '0';
                int res = hand(mark, t);
                stringBuilder.append(res);
                queue.add(res);
                mark ^= queue.getLast();
            } else {
                int t = num.charAt(i) - '0';
                int res = hand(mark, t);
                stringBuilder.append(res);
                mark ^= res;
                queue.add(res);
            }
        }
        System.out.println(stringBuilder.toString());

    }

    public static int hand(int mark, int num) {
        if (mark == 0) {
            return num;
        } else {
            if (num == 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void f3() {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.valueOf(scanner.nextLine());
        int[] age = new int[len];
        int[] pre = new int[len];
        int[] sus = new int[len];
        String[] strings = scanner.nextLine().split(" ");
        for (int i = 0; i < len; i++) {
            age[i] = Integer.valueOf(strings[i]);
        }
        pre[0] = 100;
        sus[len - 1] = 100;
        for (int i = 1; i < len; i++) {
            if (age[i] > age[i - 1]) {
                pre[i] = pre[i - 1] + 100;
            } else {
                pre[i] = 100;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (age[i] > age[i + 1]) {
                sus[i] = sus[i + 1] + 100;
            } else {
                sus[i] = 100;
            }
        }
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(sus));
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.max(pre[i], sus[i]);
        }
        System.out.println(res);
    }

    public static void f4() {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        ArrayList<Integer>[] arrayLists = new ArrayList[num];
        for (int i = 0; i < num; i++) {
            hand(arrayLists, scanner.nextLine());
        }
    }
    public static void hand(ArrayList[] arrayLists,String str){
        String[] strings = str.split(" ");
        int a = Integer.valueOf(strings[0]);
        int b = Integer.valueOf(strings[1]);
        if (arrayLists[a] == null) {
            arrayLists[a] = new ArrayList();
        }
        if (arrayLists[b] == null) {
            arrayLists[b] = new ArrayList();
        }
        arrayLists[a].add(b);
        arrayLists[b].add(a);
    }
}
