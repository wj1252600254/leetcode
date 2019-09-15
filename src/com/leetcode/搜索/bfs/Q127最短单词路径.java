package com.leetcode.搜索.bfs;

import java.util.LinkedList;
import java.util.List;

public class Q127最短单词路径 {
    /**
     * 可以用双端bfs
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> list = new LinkedList<>();
        int cnt = 0;
        list.add(beginWord);
        boolean[] marked = new boolean[wordList.size()];
        while (!list.isEmpty()) {
            int size = list.size();
            cnt++;
            while (size-- > 0) {
                String p = list.pop();
                for (int i = 0; i < wordList.size(); i++) {
                    if (p.equals(endWord))
                        return cnt;
                    String t = wordList.get(i);
                    if (marked[i] || !isChangedOnce(p, t))
                        continue;
                    marked[i] = true;
                    list.add(t);
                }
            }
        }
        return 0;
    }

    private boolean isChangedOnce(String a, String b) {
        int times = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                times++;
                if (times > 1)
                    return false;
            }
        }
        return times != 0;
    }
}
