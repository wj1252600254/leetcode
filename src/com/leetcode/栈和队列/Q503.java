package com.leetcode.栈和队列;

import java.util.Arrays;
import java.util.Stack;

public class Q503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len * 2; i++) {
            int num = nums[i % len];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                ans[stack.pop()] = num;
            }
            if (i < len) {
                stack.push(i);
            }
        }
        return ans;
    }
}
