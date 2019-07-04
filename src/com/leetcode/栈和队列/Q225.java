package com.leetcode.栈和队列;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q225 {
    class MyStack {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.offer(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.removeLast();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peekLast();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
