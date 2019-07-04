package com.leetcode.栈和队列;

import java.util.Stack;

public class Q20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char cc = stack.pop();
                if (c == '}' && cc != '{' || c == ']' && cc != '[' || c == ')' && cc != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
