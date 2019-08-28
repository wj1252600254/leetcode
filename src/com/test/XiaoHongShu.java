package com.test;

import java.util.Arrays;
import java.util.Scanner;

public class XiaoHongShu {
    public static void main(String[] args) {
        f3();
    }

    public static void ff1(String s) {
        String[] strings = s.split(" ");
        int target = Integer.valueOf(strings[0]);
        String[] ints = strings[1].substring(1, strings[1].length() - 1).split(",");
        System.out.println(Arrays.toString(ints));
        int len = ints.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {

            nums[i] = Integer.valueOf(ints[i].trim());
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = num; i <= target; i++) {
                dp[i] += dp[i - num];
            }
        }
        System.out.println(dp[target]);
    }

    public static void f1() {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int target = Integer.valueOf(strings[0]);
        String[] ints = strings[1].substring(1, strings[1].length() - 1).split(",");
        int len = ints.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.valueOf(strings[i]);
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = num; i <= target; i++) {
                dp[i] += dp[i - num];
            }
        }
        System.out.println(dp[target]);

    }

    public static void ff2(String a) {
        char[] chars = a.toCharArray();
        int len = chars.length;
        StringBuilder stringBuilder = new StringBuilder();
        int left = 0;
        int right = 0;
        boolean isSpa = false;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') {
                continue;
            }
            while (chars[i] == ' ' && chars[i - 1] == ' ') {
                i++;
                isSpa = true;
            }
            if (isSpa) {
                left = i;
                continue;
            }
            right = i - 1;
            reverse(chars, left, right);
            for (int m = left; m <= i; m++) {
                stringBuilder.append(chars[m]);
            }
            left = i + 1;
        }
        reverse(chars, left, len - 1);
        for (int m = left; m < len; m++) {
            stringBuilder.append(chars[m]);
        }
        System.out.println(stringBuilder.reverse().toString().trim());
    }

    public static void f2() {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine().trim();
        char[] chars = a.toCharArray();
        int len = chars.length;
        StringBuilder stringBuilder = new StringBuilder();
        int left = 0;
        int right = 0;
        boolean isSpa = false;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') {
                continue;
            }
            while (chars[i] == ' ' && chars[i - 1] == ' ') {
                i++;
                isSpa = true;
            }
            if (isSpa) {
                left = i;
                continue;
            }
            right = i - 1;
            reverse(chars, left, right);
            for (int m = left; m <= i; m++) {
                stringBuilder.append(chars[m]);
            }
            left = i + 1;
        }
        reverse(chars, left, len - 1);
        for (int m = left; m < len; m++) {
            stringBuilder.append(chars[m]);
        }
        System.out.println(stringBuilder.reverse().toString().trim());
    }

    public static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void f3() {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.valueOf(scanner.nextLine());
        String[] strings = scanner.nextLine().split(" ");
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.valueOf(strings[i]);
        }
        int pre1 = nums[0], pre2 = 0, cur = 0;
        int cnt1=1,cnt2=0,curcnt=0;
        for (int i = 1; i < len; i++) {
//            cur = Math.max(pre1, pre2 + nums[i]);
            if (pre1>=pre2+nums[i]) {
                curcnt = cnt1;
                cur = pre1;
            } else {
                curcnt = cnt2 + 1;
                cur = pre2 + nums[i];
            }
            cnt2 = cnt1;
            cnt1 = curcnt;
            pre2 = pre1;
            pre1 = cur;
        }
        System.out.println(cur+" "+curcnt);
    }

    public static int getMax(int[] nums,int len) {
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > res) {
                res = nums[i];
            }
        }
        return res;
    }


    public static void f4() {
        Scanner scanner = new Scanner(System.in);
    }
}
