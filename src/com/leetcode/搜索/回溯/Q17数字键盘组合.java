package com.leetcode.搜索.回溯;

import java.util.ArrayList;
import java.util.List;

public class Q17数字键盘组合 {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0)
            return list;
        dfs(digits, new StringBuilder(), list);
        return list;
    }

    private void dfs(String digits, StringBuilder str, List<String> list) {
        if (digits.length() == str.length()) {
            list.add(str.toString());
            return;
        }
        String key = KEYS[digits.charAt(str.length()) - '0'];
        for (char c : key.toCharArray()) {
            str.append(c);
            dfs(digits, str, list);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
