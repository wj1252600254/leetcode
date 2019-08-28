package com.leetcode.图;

import java.util.*;

public class 拓扑排序 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{2, 1}, {3, 1}, {4, 2}, {4, 3}};
        int[] weight = new int[]{1, 2, 3, 4};
//        bfs(4, arr, weight);
        dfsTopu(4,arr);
    }

    //BFS拓扑排序
    public static void bfs(int n, int[][] arr, int[] weight) {
        List<Integer>[] lists = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        int[] inDgree = new int[n + 1];
        for (int[] t : arr) {
            lists[t[1]].add(t[0]);
            inDgree[t[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
//            Collections.sort(lists[i],(a,b)->{return  weight[b]-weight[a];});
            if (inDgree[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int noe = queue.poll();
            result.add(noe);
            List<Integer> arrayList = lists[noe];
            for (int temp : arrayList) {
                inDgree[temp]--;
                if (inDgree[temp] == 0) {
                    queue.add(temp);
                }
            }
        }
        System.out.println(result);
    }

    public static void dfsTopu(int n, int[][] arr) {
        int[] mared = new int[n + 1];
        Set<Integer>[] set = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) {
            set[i] = new HashSet<>();
        }
        for (int[] temp : arr) {
            set[temp[1]].add(temp[0]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            if (dfs(mared, i, set, stack)) {
                System.out.println("存在环");
                return;
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = stack.pop();
        }
        System.out.println(Arrays.toString(res));
    }
    private static boolean dfs(int[] marked,int index,Set<Integer>[] set,Stack<Integer> stack) {
        if (marked[index] == 1) {
            return true;
        }
        if (marked[index] == 2) {
            return false;
        }
        marked[index] = 1;
        Set<Integer> set1 = set[index];
        for (int temp : set1) {
            if (dfs(marked, temp, set, stack)) {
                return true;
            }
        }
        marked[index] = 2;
        stack.add(index);
        return false;
    }
}
