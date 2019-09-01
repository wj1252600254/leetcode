package com.test;

import java.util.*;

public class pdd提前批 {


    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(new pdd提前批().findNumber(a, 5));
    }


    public void q1() {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String[] strings1 = s1.split(" ");
        String[] strings2 = s2.split(" ");
        int len1 = strings1.length;
        int len2 = strings2.length;
        int[] A = new int[len1];
        int[] B = new int[len2];
        for (int i = 0; i < len1; i++) {
            A[i] = Integer.valueOf(strings1[i]);
        }
        for (int i = 0; i < len2; i++) {
            B[i] = Integer.valueOf(strings2[i]);
        }
        Arrays.sort(B);
        for (int i = 1; i < len1; i++) {
            if (A[i] > A[i - 1]) {
                continue;
            }
            if (i == len1 - 1 && B[i] > A[i]) {
                A[i] = B[i];
                System.out.println(Arrays.toString(A));
                return;
            } else {
                int res = findNumber(B, A[i + 1] - 1);
                if (B[res] <= A[i - 1]) {
                    System.out.println("NO");
                    return;
                } else {
                    A[i] = B[res];
                    for (int j = 0; j < len1 - 1; j++) {
                        System.out.print(A[j] + " ");
                    }
                    System.out.print(A[len1 - 1]);
                    return;
                }
            }
        }

    }

    public int findNumber(int[] a, int target) {
        int l = 0, h = a.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (a[m] == target) {
                return m;
            } else if (a[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public void q2() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        int len = strings.length;
        int[] judge = new int[len];
        for (int i = 0; i < len; i++) {
            int temp = 1;
            for (char c : strings[i].toCharArray()) {
                temp |= temp << (c - 'A');
            }
            judge[i] = temp;
        }
        int a = 0, b = 0;
        for (int i = 2; i < len; i++) {
            if ((a = judge[i] & judge[i - 1]) != 0 && ((b = judge[i - 2] & judge[i - 1]) != 0) && (a != b)) {
                continue;
            }
            System.out.println("false");
            return;
        }
        if (len >= 2 && (a = judge[0] & judge[len - 1]) != 0 && ((b = judge[len - 1] & judge[len - 2]) != 0) && (a != b)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public void q3() {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String[] strings1 = s1.split(" ");
        int n = Integer.valueOf(strings1[0]);
        String s2 = scanner.nextLine();
        String[] strings2=s2.split(" ");
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i]=Integer.valueOf(strings2[i]);
        }
        ArrayList<Integer>[] set = new ArrayList[n];
        int[] marked = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = new ArrayList<>();
        }
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            String[] strings = temp.split(" ");
            set[Integer.valueOf(strings[0])].add(Integer.valueOf(strings[1]));
        }
        for (int i = 0; i < n; i++) {
            if (dfs(i, marked, set)) {
                return;
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = stack.poll();
        }
        for (int i = 0; i < n-1; i++) {
            System.out.print(ans[i]+" ");
        }
        System.out.print(ans[n-1]);
    }

    Queue<Integer> stack = new ArrayDeque<>();

    private boolean dfs(int curNode, int[] marked, ArrayList<Integer>[] graph) {
        if (marked[curNode] == 1)
            return true;
        if (marked[curNode] == 2)
            return false;
        marked[curNode] = 1;
        ArrayList<Integer> a = graph[curNode];
        for (int p : a) {
            if (dfs(p, marked, graph)) {
                return true;
            }
        }
        marked[curNode] = 2;
        stack.add(curNode);
        return false;
    }

    public void q4() {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String s3 = scanner.nextLine();
        int len = Integer.valueOf(s1);
        int[][] arr = new int[10][2];
        String[] strings2 = s2.split(" ");
        String[] strings3 = s3.split(" ");
        for (int i = 0; i < len; i++) {
            arr[i][0] = Integer.valueOf(strings2[i]);
            arr[i][1] = Integer.valueOf(strings3[i]);
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
//        int
    }
}
