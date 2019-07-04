package com.leetcode.图;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;

public class Q210 {
    Queue<Integer> stack=new ArrayDeque<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        HashSet<Integer>[] set = new HashSet[numCourses];
        //节点数等于课程数
        int[] marked = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            set[i] = new HashSet<Integer>();
        }
        for (int[] p : prerequisites) {
            set[p[0]].add(p[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, marked, set)) {
                return new int[0];
            }
        }
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i]=stack.poll();
        }
        return ans;
    }

    private boolean dfs(int curNode, int[] marked, HashSet<Integer>[] graph) {
        if (marked[curNode] == 1)
            return true;
        if (marked[curNode] == 2)
            return false;
        marked[curNode] = 1;
        HashSet<Integer> a = graph[curNode];
        for (int p : a) {
            if (dfs(p, marked, graph)) {
                return true;
            }
        }
        marked[curNode] = 2;
        stack.add(curNode);
        return false;
    }
}
