package com.cc.algo.base.sort;

import java.util.Arrays;

public class ShellSort {
    private static final int[] nums = {5, 9, 8, 7, 6, 4, 3, 2, 1, 0};

    public static void main(String[] args) {
        ShellSort process = new ShellSort();

        process.shell_sort(nums);

        System.out.println(Arrays.toString(nums));
    }

    // 希尔排序，是插入排序的改进版本，是分组插入排序，每个组有序，然后合并组，合并组有序，最终达到整体有序。
    void shell_sort(int[] nums) {
        if (nums == null) return;
        //1、根据数据长度，平分，分组，保证每一个分组内是有序的，先按照每组两个，分成若干组。gap
        //2、保证若干组内，每一组内都是有序的，利用插入排序。
        //3、合并两个有序组，达到整体有序，组数减少，组的成员变多，利用插入排序保证新的组有序。降低 gap
        //4、到成为一个组，就有序了，进行了若干次的插入排序。
        int len = nums.length;

        int tmp, gap = len / 2;
        while (gap > 0) {
            // 这里 i=gap 可以理解为 i= 1*gap 就是从下一个 进行在原基础上的 插入排序
            for (int i = gap; i < len; i++) {
                //怎么保证上来有序的，首先分成每组两个，对后一个判断，插入，可以保证。
                //要插入的元素
                tmp = nums[i];//这就是下一个
                //这组的前一个元素
                int preIndex = i - gap;
                //轮询：这组有内容，并且要插入的内容的前一个小于待插入的，就把前边的放到这个位置。
                while (preIndex >= 0 && nums[preIndex] > tmp) {
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex + gap] = tmp;
            }
            gap /= 2;
        }
    }
}
