package com.test;

import com.ListNode;

import java.util.Stack;

public class Crip {

    public static void main(String[] args) {

    }

    public static ListNode f1(ListNode head, int m) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while (head != null && head.val <= m) {
            cur.next = head;
            cur = cur.next;
            head = head.next;
        }
        if (head == null) {
            return newHead.next;
        }
        ListNode next = head.next;
        ListNode pre = head;
        while (next != null) {
            if (next.val <= m) {
                cur.next = next;
                cur = cur.next;
                pre.next = next.next;
                next = next.next;
            } else {
                pre = next;
                next = next.next;
            }
        }
        cur.next = head;
        return newHead.next;
    }

    static String resolve(String expr) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        char[] chars = expr.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char t = chars[i];
            if (t == '(') {
                stack.push(i);
            } else if (t == ')') {
                if (stack.isEmpty()) {
                    return "";
                } else {
                    int start = stack.pop();
                    reverse(start, i, chars);
                }
            }
        }
        if (!stack.isEmpty()) {
            return "";
        }
        for (int i = 0; i < len; i++) {
            char t = chars[i];
            if (t != '(' && t != ')') {
                sb.append(t);
            }
        }

        return sb.toString();
    }

    static void reverse(int start, int end, char[] chars) {
        while (start < end) {
            swap(start++, end--, chars);
        }
    }

    static void swap(int m, int n, char[] chars) {
        char temp = chars[m];
        chars[m] = chars[n];
        chars[n] = temp;
    }

    static int schedule(int m, int[] array) {
        int len = array.length;
        int remainNode = m;
        int sum = getSum(array);
        int[] remain = getRemain(array, len, sum);
        int ave = sum / m;
        int min = ave;
        for (int i = 0; i < len; i++) {
            if (array[i] > min) {
                remainNode--;
                min = array[i];
                continue;
            }
            int cur = 0;
            for (int j = 0; j < len; j++) {
                if (cur < min) {
                    cur += array[j];
                } else {
                    if (remain[j - 1] / (remainNode - 1) > min) {
                        min = cur;
                        remainNode--;
                    } else {
                        
                    }
                }
            }
        }
        return min;
    }

    static int getSum(int[] array) {
        int res = 0;
        for (int t : array) {
            res += t;
        }
        return res;
    }

    static int[] getRemain(int[] array, int len, int res) {
        int[] remain = new int[len];
        for (int i = 0; i < len; i++) {
            res -= array[i];
            remain[i] = res;
        }
        return remain;
    }
}
