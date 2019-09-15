package com.leetcode.分治;

import java.util.ArrayList;
import java.util.List;

public class Q241给表达式加括号 {
    public static void main(String[] args) {
        new Q241给表达式加括号().diffWaysToCompute("2-1-1");
    }

    /**
     * 理解递归
     * 本题是分治的思想
     *
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int le : left) {
                    for (int ri : right) {
                        switch (c) {
                            case '+':
                                list.add(le + ri);
                                break;
                            case '-':
                                list.add(le - ri);
                                break;
                            case '*':
                                list.add(le * ri);
                        }
                    }
                }
            }
        }
        if (list.size() == 0) {
            list.add(Integer.parseInt(input));
        }
        return list;
    }
}
