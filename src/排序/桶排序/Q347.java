package 排序.桶排序;

import java.util.*;

public class Q347 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list.subList(0, 0));
    }

    /**
     * 桶排序
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();
        //如果小于等于res.size() <= k，会多执行一次循环
        for (int i = nums.length; i > 0 && res.size() < k; i--) {
            if (buckets[i] == null)
                continue;
            if (buckets[i].size() < k - res.size()) {
                res.addAll(buckets[i]);
            } else {
                res.addAll(buckets[i].subList(0, k - res.size()));
            }
        }
        return res;
    }
}
