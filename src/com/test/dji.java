//package com.test;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class dji {
//    public static void main(String[] args) {
////        q2();
//        
//    }
//
//    private static  void q1() {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String a = scanner.nextLine();
//            String b = scanner.nextLine();
//            int[] a3 = getArr(a);
//            int[] bn = getArr(b);
//            int sum = getSum(bn);
//            System.out.println(sum);
//            if (sum/a3[1] <= a3[2] * 60) {
//                if (sum % a3[1] != 0) {
//                    System.out.println(sum / a3[1] + 1);
//                } else {
//                    System.out.println(sum / a3[1]);
//                }
//            } else {
//                int diff=sum/a3[1]-a3[2]*60;
//                int res = a3[2] * 60  + diff*a3[1];
//                if (res > 640) {
//                    System.out.println(0);
//                } else {
//                    System.out.println(res);
//                }
//            }
//        }
//    }
//
//    private static void f(int[] a3,int [] bn) {
//        int sum = getSum(bn);
//        System.out.println(sum);
//        if (sum/a3[1] <= a3[2] * 60) {
//            if (sum % a3[1] != 0) {
//                System.out.println(sum / a3[1] + 1);
//            } else {
//                System.out.println(sum / a3[1]);
//            }
//        } else {
//            int diff=sum-a3[1]*a3[2]*60;
//            int res = a3[2] * 60  + diff;
//            if (res > 640) {
//                System.out.println(0);
//            } else {
//                System.out.println(res);
//            }
//        }
//    }
//
//    private static int[] getArr(String a) {
//        String[] strings=a.split(" ");
//        int[] arr = new int[strings.length];
//        for (int i = 0; i < strings.length; i++) {
//            arr[i] = Integer.valueOf(strings[i]);
//        }
//        return arr;
//    }
//
//    private static int getSum(int[] arr) {
//        int sum=0;
//        for (int t : arr) {
//            sum += t;
//        }
//        return sum;
//    }
//
////    public static void q2() {
////        Scanner scanner = new Scanner(System.in);
////        while (scanner.hasNextLine()) {
////            String a = scanner.nextLine();
////            String[] strings = a.split(" ");
////            int num = Integer.valueOf(strings[0]);
////            int money = Integer.valueOf(strings[1]);
////            int[][] res = getArr(scanner, num);
////            dp(res,money);
////        }
////    }
//
//
//    private static void dp(int[][] arr, int money) {
//        int[] dp = new int[money + 1];
//        for (int[] t : arr) {
//            int v=t[0];
//            int i = t[1];
//            for (int j = money; j >= v; j--) {
//                dp[j] = Math.max(dp[j], dp[j - v]+i);
//            }
//        }
//        System.out.println(dp[money]);
//    }
//
//    private static ArrayList<Integer>[] getArr(Scanner scanner, int P, int N) {
//        ArrayList<Integer>[] arrayList = new ArrayList[P];
//        for (int i = 0; i < N; i++) {
//            int[] temp = getArr(scanner.nextLine());
//            arrayList[temp[0]].add(temp[1]);
//        }
//        return arrayList;
//    }
//
//    private static int[] getTar(Scanner scanner, int C) {
//        int[] tar = new int[C];
//        for (int i = 0; i < C; i++) {
//            tar[i]=Integer.valueOf(scanner.nextLine());
//        }
//        return tar;
//    }
//
//    public static void q3() {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String a = scanner.nextLine();
//            String[] strings = a.split(" ");
//            int N = Integer.valueOf(strings[0]);
//            int P = Integer.valueOf(strings[1]);
//            int C = Integer.valueOf(strings[2]);
//            ArrayList<Integer>[] arrayLists = getArr(scanner, P, N);
//            int[] tar = getTar(scanner, C);
//            findMin(arrayLists,tar,0);
//        }
//    }
//
//    public static void findMin(ArrayList<Integer>[] arrayList, int[] tar,int node) {
//        int min=0;
//        for (int temp:arrayList[node])
//    }
//}
