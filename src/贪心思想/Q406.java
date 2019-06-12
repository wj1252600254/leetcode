package 贪心思想;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q406 {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{1, 3});
        System.out.println(list.toArray(new int[list.size()][]));
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(32);
        list1.add(0, 100);
        System.out.println(Arrays.toString(list1.toArray()));
        //返回数组指定的类型
        System.out.println(Arrays.toString(list1.toArray(new Integer[list1.size()])));
    }


    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        //正确处理顺序
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[list.size()][]);

    }
}
