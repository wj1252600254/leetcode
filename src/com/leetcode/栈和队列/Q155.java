package com.leetcode.栈和队列;

import java.util.Stack;

public class Q155 {
    class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> min = new Stack<>();
        int m = Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            m = Math.min(m, x);
            stack.push(x);
            min.push(m);
        }

        public void pop() {
            stack.pop();
            min.pop();
            m = min.isEmpty() ? Integer.MAX_VALUE : min.peek();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
