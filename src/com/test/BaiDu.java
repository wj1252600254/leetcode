package com.test;

import java.util.*;

public class BaiDu {
    public static void main(String[] args) {
//        Line line = new Line(1, 2, 34, 4);
//        Line line1 = new Line(1, 2, 5, 6);
//        Set<Line> set = new HashSet<>();
//        set.add(line);
//        set.add(line1);
//        System.out.println(set.size());
        f3();
    }

    public static void f1() {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long m = scanner.nextInt();
        long k = scanner.nextLong();
        if (k == n * m) {
            System.out.println(0);
            return;
        }
        if (n <= m) {
            System.out.println(handle(n, m, k));
        } else {
            System.out.println(handle(m, n, k));
        }
    }


    public static long handle(long n, long m, long k) {
        long a = 0, b = 0;
        long l = 0, h = n;
        while (l < h) {
            long mid = l + (h - l) / 2;
            if (mid * m <= k && (mid + 1) * m > k) {
                a = n - mid;
                b = 0;
                break;
            } else if (mid * m < k) {
                l = mid;
            } else {
                h = mid;
            }
        }

        return a + b;
    }

    public static void f2() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] ans = new String[num];
        for (int i = 0; i < num; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            handle(scanner, ans, i, n, m);
        }
        for (int i = 0; i < num; i++) {
            System.out.println(ans[i]);
        }

    }

    static void handle(Scanner scanner, String[] strings, int num, int n, int m) {
        ArrayList<Integer>[] arrayLists = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a < b) {
                arrayLists[b].add(a);
            } else {
                arrayLists[a].add(b);
            }
        }
        if (arrayLists[n].size() == 0) {
            strings[num] = "IMPOSSIBLE";
            return;
        }
        for (int t : arrayLists[n]) {
            if (t == 1) {
                strings[num] = "POSSIBLE";
                return;
            }
            if (arrayLists[t].contains(1)) {
                strings[num] = "POSSIBLE";
                return;
            }
        }
        strings[num] = "IMPOSSIBLE";
    }


    public static void f3() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int Fa = scanner.nextInt();
        int Fb = scanner.nextInt();
        UF uf = new UF(N);
        Set<Line> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            Line line = null;
            if (u < v) {
                line = new Line(u, v, a, b);
            } else {
                line = new Line(v, u, a, b);
            }
            if (set.contains(line)) {
                for (Line line1 : set) {
                    if (line1.equals(line)) {
                        if ((line.a * Fa + line.b * Fb) < (line1.a * Fa + line1.b * Fb)) {
                            set.remove(line1);
                            set.add(line);
                        }
                        break;
                    }
                }
            } else if (!uf.isconnect(v, u)) {
                set.add(line);
                uf.connect(u, v);
            } else {

            }
        }
        int maxa = 0;
        int maxb = 0;
        for (Line t : set) {
            maxa = Math.max(maxa, t.a);
            maxb = Math.max(maxb, t.b);
        }
        System.out.println(maxa * Fa + maxb * Fb);
    }

    static class UF {
        int[] num;

        public UF(int n) {
            num = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                num[i] = i;
            }
        }

        public boolean isconnect(int u, int v) {
            if (num[u] == num[v]) {
                return true;
            } else {
                return false;
            }
        }

        public void connect(int u, int v) {
            num[u] = 0;
            num[v] = 0;
        }
    }

    static class Line {
        public int u;
        public int v;
        public int a;
        public int b;

        public Line(int u, int v, int a, int b) {
            this.u = u;
            this.v = v;
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return u == line.u &&
                    v == line.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v);
        }
    }
}
