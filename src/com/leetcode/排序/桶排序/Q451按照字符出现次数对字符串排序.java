package com.leetcode.排序.桶排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q451按照字符出现次数对字符串排序 {
    //特使StringBuilder的append
    public static void main(String[] args) {


        Integer[] a = {1, 2, 3, 4, 5, 6};
        Object[] o = a;
        Integer[] b = (Integer[]) o;
        System.out.println(Arrays.toString(b));


        StringBuilder s = new StringBuilder();
        char[] chars = new char[]{'a', 'b'};
        ArrayList<Character> arrayList = new ArrayList();
        arrayList.add('a');
        arrayList.add('c');
        //不可以转型
        System.out.println((Character[]) arrayList.toArray());

    }

    /**
     * 桶排序
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        ArrayList<Character>[] arrayLists = new ArrayList[s.length() + 1];
        for (char c : map.keySet()) {
            int frequency = map.get(c);
            if (arrayLists[frequency] == null) {
                arrayLists[frequency] = new ArrayList<>();
            }
            arrayLists[frequency].add(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length(); i > 0; i--) {
            if (arrayLists[i] == null)
                continue;
            for (char c : arrayLists[i]) {
                for(int j=i-1;j>=0;j--){
                    stringBuilder.append(c);
                }
            }

        }
        return stringBuilder.toString();
    }
}
