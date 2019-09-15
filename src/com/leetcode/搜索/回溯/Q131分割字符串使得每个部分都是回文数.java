package com.leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

public class Q131分割字符串使得每个部分都是回文数 {
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        if (s.length() == 0)
            return lists;
        dfs(s, lists, new ArrayList<>());
        return lists;
    }

    private void dfs(String s, List<List<String>> lists, List<String> list) {
        if (s.length() == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isHW(s, 0, i)) {
                list.add(s.substring(0, i + 1));
                dfs(s.substring(i + 1, s.length()), lists, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isHW(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else
                return false;
        }
        return true;
    }
}
