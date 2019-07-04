package com.leetcode.栈和队列;

import java.util.Stack;

public class Q232 {
    class MyQueue {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (stack1.isEmpty()) {
                while (!stack.isEmpty()) {
                    stack1.push(stack.pop());
                }
            }
            return stack1.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (stack1.isEmpty()) {
                while (!stack.isEmpty()) {
                    stack1.push(stack.pop());
                }
            }
            return stack1.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack1.isEmpty() && stack.isEmpty();
        }
    }
}
