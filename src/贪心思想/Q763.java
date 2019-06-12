package 贪心思想;

import java.util.ArrayList;
import java.util.List;

public class Q763 {
    public static void main(String[] args) {
        System.out.println("ababcbacadefegdehijhklij".substring(0));
        System.out.println("ababcbacadefegdehijhklij".substring(1));
        System.out.println(new Q763().partitionLabels("ababcbacadefegdehijhklij"));

    }

    /**
     *         while (S.length() != 0) {
     *             int last = S.lastIndexOf(S.charAt(0));
     *             for (int i = 0; i < last; i++) {
     *                 if (S.lastIndexOf(S.charAt(i)) <= last)
     *                     continue;
     *                 last = S.lastIndexOf(S.charAt(i));
     *             }
     *             S = S.substring(last);
     *             list.add(last + 1);
     *         }
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {

        List<Integer> list = new ArrayList<>();
        dfs(S, list);
        return list;

    }
    private void dfs(String s, List<Integer> list) {
        if (s.length() == 0)
            return;
        char first = s.charAt(0);
        int last = s.charAt(first);
        for (int i = 0; i < last; i++) {
            if (s.lastIndexOf(s.charAt(i)) <= last)
                continue;
            last = s.lastIndexOf(s.charAt(i));
        }
        s = s.substring(last + 1);
        list.add(last + 1);
        dfs(s, list);
    }

}

