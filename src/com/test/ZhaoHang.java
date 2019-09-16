package com.test;

import java.util.Scanner;

public class ZhaoHang {
    public static void main(String[] args) {
        f3();
    }

    public static void f1() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int len = str.length();
        int[] ans = new int[len];
        int cnt = 0;
        for (int i = 1; i < len; i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                cnt++;
                if (i != len - 1) {
                    continue;
                } else {
                    if ((cnt & 1) == 1) {
                        if (str.charAt(i - 1) == 'R') {
                            ans[i] += cnt / 2 + 2;
                            ans[i - 1] += cnt / 2 + 1;
                        } else {
                            ans[i - cnt - 1] += cnt / 2 + 1;
                            ans[i - cnt] += cnt / 2;
                        }
                    } else {
                        if (str.charAt(i - 1) == 'R') {
                            ans[i] += cnt / 2 + 1;
                            ans[i - 1] += cnt / 2 + 1;
                        } else {
                            ans[i - cnt - 1] += cnt / 2;
                            ans[i - cnt] += cnt / 2;
                        }
                    }
                }
            } else {
                if ((cnt & 1) == 1) {
                    if (str.charAt(i - 1) == 'R') {
                        ans[i] += cnt / 2 + 2;
                        ans[i - 1] += cnt / 2 + 1;
                    } else {
                        ans[i - cnt - 1] += cnt / 2 + 1;
                        ans[i - cnt] += cnt / 2;
                    }
                } else {
                    if (str.charAt(i - 1) == 'R') {
                        ans[i] += cnt / 2 + 1;
                        ans[i - 1] += cnt / 2 + 1;
                    } else {
                        ans[i - cnt - 1] += cnt / 2;
                        ans[i - cnt] += cnt / 2;
                    }

                }
            }
            cnt = 0;
        }
        for (int i = 0; i < len - 1; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.print(ans[len - 1]);

    }

    public static void f2() {
        Scanner scanner = new Scanner(System.in);
    }

    private static long cnt = 0;

    public static void f3() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int len = str.length();
        boolean[] mark = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '?') {
                mark[i] = true;
            }
        }
        dfs(str.toCharArray(), 0, mark, len);
        System.out.println((int) (cnt % (Math.pow(10, 9) + 7)));
    }

    public static void dfs(char[] str, int start, boolean[] mark, int len) {
        if (start == len) {
            if (Integer.valueOf(new String(str)) % 13 == 5) {
                cnt++;
            }
            return;
        }

        if (mark[start]) {
            for (int i = 0; i < 9; i++) {
                if (start == 0 && i == 0) {
                    continue;
                }
                str[start] = (char) (48 + i);
                mark[start] = false;
                dfs(str, start + 1, mark, len);
                str[start] = '?';
                mark[start] = true;
            }
        } else {
            dfs(str, start + 1, mark, len);
        }

    }
}
