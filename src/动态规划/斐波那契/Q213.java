package 动态规划.斐波那契;

public class Q213 {
    /**
     * 采用空间优化版本
     * Q198
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        else if (len == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums, 0, len - 2), rob(nums, 1, len - 1));

    }

    private int rob(int[] nums, int start, int end) {
        int pre1 = 0, pre2 = 0;
        int cur = 0;
        for (int i = start; i <= end; i++) {
            cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
}
