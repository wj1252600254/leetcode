package com.leetcode.链表;

import com.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q725 {
    public static void main(String[] args) {
        int[] a = new int[10];
        Arrays.fill(a, 0, 2, 3);
        System.out.println(Arrays.toString(a));
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] listNodes = new ListNode[k];
        int cnt = 0;
        ListNode head = root;
        while (head != null) {
            head = head.next;
            cnt++;
        }
        int[] lens = new int[k];
        if (cnt / k <= 0) {
            for (int i = 0; i < k; i++)
                lens[i] = 1;
        } else {
            int mod = cnt % k;
            int a = cnt / k;
            if (mod == 0)
                Arrays.fill(lens, a);
            else {
                Arrays.fill(lens, 0, mod, a + 1);
                Arrays.fill(lens, mod, k, a);
            }
        }
        for (int i = 0; i < k; i++) {
            int len = lens[i];
            if (len > 0) {
                ListNode fir = root;
                while (--len > 0) {
                    fir = fir.next;
                }
                if (fir != null) {
                    ListNode next = fir.next;
                    fir.next = null;
                    listNodes[i] = root;
                    root = next;
                } else {
                    listNodes[i] = root;
                }

            } else {
                listNodes[i] = null;
            }
        }
        return listNodes;
    }
}
