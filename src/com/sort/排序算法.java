package com.sort;

import java.util.Arrays;

public class 排序算法 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 1, 4, 3, 6, 5};
        排序算法 aa = new 排序算法();
        aa.dumpsort(a);

        display(a);
    }


    /**
     * 分为两步，第一步是构建大顶堆
     * 第二步是交换头尾节点，重新调整
     *
     * @param nums
     */
    public void dumpsort(int[] nums) {
        int len = nums.length;
        //1
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustdump(nums, i, len);
        }
        //2
        for (int j = len - 1; j > 0; j--) {
            swap(nums,j,0);
            adjustdump(nums, 0, j);
        }
    }

    private void adjustdump(int[] nums, int sta, int len) {
        int temp = nums[sta];
        for (int i = 2 * sta + 1; i < len; i++) {
            if (i < len - 1 && nums[i] < nums[i + 1]) {
                i++;
            }
            if (nums[i] > nums[sta]) {
                nums[sta] = nums[i];
                sta = i;
            } else
                break;
        }
        nums[sta] = temp;
    }


    //插入排序
    public void insertsort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (less(nums[j], nums[j - 1])) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }


    //冒泡排序
    public void bubblesort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = i + 1; j < len; j++) {
                if (less(nums[j], nums[j - 1])) {
                    swap(nums, j, j - 1);
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

    //选择排序
    public void selectSort(int[] nums) {
        int len = nums.length;
        int min = 0;
        for (int i = 0; i < len; i++) {
            min = i;
            for (int j = i + 1; j < len; j++) {
                if (less(nums[j], nums[i])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    private boolean less(int a, int b) {
        if (a < b) {
            return true;
        }
        return false;
    }

    private void swap(int[] nums, int a, int b) {
//        nums[a] = nums[a] ^ nums[b];
//        nums[b] = nums[a] ^ nums[b];
//        nums[a] = nums[a] ^ nums[b];
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void display(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}
