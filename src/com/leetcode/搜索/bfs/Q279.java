package com.leetcode.搜索.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q279 {
    public int numSquares(int n) {
        List<Integer> list = generateSquares(n);
        LinkedList<Integer> mid = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        marked[n] = true;
        mid.add(n);
        int cnt = 0;
        while (!mid.isEmpty()) {
            int size = mid.size();
            cnt++;
            while (size-- > 0) {
                int c = mid.poll();
                for (int t : list) {
                    int diff = c - t;
                    if (diff == 0)
                        return cnt;
                    if (diff < 0)
                        break;
                    if (marked[diff])
                        continue;
                    marked[diff] = true;
                    mid.add(diff);
                }
            }
        }
        return n;
    }

    private List<Integer> generateSquares(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int squar = 1, diff = 3;
        while (squar < n) {
            squar += diff;
            diff += 2;
            list.add(squar);
        }
        return list;
    }
}
