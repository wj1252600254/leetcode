package com.test;

import java.util.Formatter;
import java.util.Scanner;

public class HW731 {
    public static void main(String[] args) {
        System.out.println(356.0/113);
        System.out.println("111".equals("111 "));
        double a=356.0/113;
        double b = 356.0 / 113;
        System.out.println(a==b);
        Formatter formatter = new Formatter();
//        formatter.format("%",)
        System.out.println(Double.valueOf("3.14159265358979"));
        System.out.println(2/1+0.0);
        new HW731().df1("0.50000000000000");
    }

    public void df1(String a) {
        double D = Double.valueOf(a);
        double min = Double.MAX_VALUE;
        double diff = 0.0;
        int M=0,N=0;
        double temp = 0.0;
        int a1 = 0, a2 = 0,t=0;
        for (int i =1; i <= 10000; i++) {
            temp = i * D;
            a1 = (int) temp;
            a2 = ((int) temp) + 1;
            if ((Math.abs(a1 / i - D)) <= (Math.abs(a2 / i - D))) {
                diff = Math.abs((double) a1 / i - D);
                t = a1;
            } else {
                diff = Math.abs((double) a2 / i - D);
                t = a2;
            }
            if (diff == 0) {
                System.out.println(M + " " + i);
                return;
            } else if (diff < min) {
                min = diff;
                M = t;
                N=i;
            }
        }
        System.out.println(M+" "+N);
    }


    public void f1() {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        double D = Double.valueOf(a);
        double min = Double.MAX_VALUE;
        double diff = 0.0;
        int M=0,N=0;
        double temp = 0.0;
        int a1 = 0, a2 = 0,t=0;
        for (int i =1; i <= 10000; i++) {
            temp = i * D;
            a1 = (int) temp;
            a2 = (int) temp + 1;
            if ((Math.abs((double) a1 / i - D)) <= (Math.abs((double) a2 / i - D))) {
                diff = Math.abs((double) a1 / i - D);
                t = a1;
            } else {
                diff = Math.abs((double) a2 / i - D);
                t = a2;
            }
            if (diff == 0) {
                System.out.println(M + " " + i);
                return;
            } else if (diff < min) {
                min = diff;
                M = t;
                N=i;
            }
        }
        System.out.println(M+" "+N);

    }




    public void f2() {
        Scanner scanner = new Scanner(System.in);
        String[] src = new String[3];
        String[] tar = new String[3];
        for (int i = 1; i <= 6; i++) {
            if ((i & 1) == 1) {
                String temp=scanner.nextLine();
                src[i / 2] = temp+temp;
            } else {
                tar[i / 2 - 1] = scanner.nextLine();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (src[i].contains(tar[i])) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }

    }

    public void f3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("A34");
    }

    public void f4() {
        Scanner scanner = new Scanner(System.in);
        int nodenumber = Integer.valueOf(scanner.nextLine());
        int len = Integer.valueOf(scanner.nextLine());
        Union union = new Union(nodenumber);
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            String[] strings = temp.split(" ");
            int a0=Integer.valueOf(strings[0].substring(1));
            int a1 = Integer.valueOf(Integer.valueOf(strings[1].substring(1)));
            if (!union.connect(a0, a1)) {
                union.union(a0, a1);
            } else {

            }
        }
    }

    class Union {
        int[] arr;
        int len;
        public Union(int len) {
            this.len = len;
            arr = new int[len+1];
            for (int i = 1; i <= len; i++) {
                arr[i] = i;
            }
        }

        public void union(int a, int b) {
            int f1 = arr[a];
            int f2 = arr[b];
            if (f1 == f2) {
                return;
            }
            for (int i = 1; i <= len; i++) {
                if (arr[i] == f2) {
                    arr[a] = f2;
                }
            }
        }

        public boolean connect(int a, int b) {
            return arr[a] == arr[b];
        }
    }

}
