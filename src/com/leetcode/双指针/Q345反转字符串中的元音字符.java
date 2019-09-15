package com.leetcode.双指针;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q345反转字符串中的元音字符 {
    /**
     * 多次使用数组中的元素的时候，可以把数组中元素的值取出来
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.addAll(Arrays.asList('a', 'A', 'i', 'I', 'u', 'U', 'e', 'E', 'O', 'o'));
        char[] chars = s.toCharArray();
        int l = 0, h = chars.length - 1;
        while (l < h) {
            if (set.contains(chars[l]) && set.contains(chars[h])) {
                swap(chars, l, h);
                l++;
                h--;
            } else if (set.contains(chars[l])) {
                h--;
            } else if (set.contains(chars[h])) {
                l++;
            } else {
                l++;
                h--;
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
