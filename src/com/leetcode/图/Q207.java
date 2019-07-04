package com.leetcode.图;

import java.util.HashSet;
import java.util.Set;

public class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0)
            return false;
        int len = prerequisites.length;
        if (len == 0)
            return true;
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
                return false;
            }
        }
        return true;
    }

    /**
     * @param curNode
     * @param marked
     * @param graph
     * @return true表示存在环
     */
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
        return false;
    }
}
