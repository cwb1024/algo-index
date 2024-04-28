package com.cc.algo.base.sort;


import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {

    private static final int[] nums = {5, 2, 3, 1};

    public static void main(String[] args) {
        CountingSort process = new CountingSort();

        process.counting_sort(nums);

        System.out.println(Arrays.toString(nums));

    }

    /**
     * 计数排序的基本需求就是：对于一个给定的输入序列中的每一个元素X，确定改序列中值小于X元素的个数（此处并非比较各元素的大小，
     * 而是通过对元素值的计算和计算的值的累加来确定）。一旦有了这个消息，就可以将X直接放到最终的输出序列的正确位置上。
     * 这里要实现的问题步骤是：
     * 确定改序列内小于X的个数并且进行累加这个值，这个对应关系需要记录下来
     * 确定几个数组：
     * 元数组
     * 计数数组 索引下标是元数据的值，内容是元数组内出现的个数
     * 计数数组进行累加操作，索引记得是元数组内的值，内容是元数组正序遍历最后一个值的出现位置
     * 结果数组
     * 利用元数组的值，在累加计数数组内找到要在结果数组内的位置，然后--操作，变更累加数组的值，等着那些重复的找到稳定的位置
     *
     * @param nums
     * @return
     */
    int[] counting_sort_0(int[] nums) {
        //需要搞一个辅助数组，记录最终的输出结果
        int[] result = new int[nums.length];
        int max = nums[0], min = nums[0];
        //这里遍历找出最大值，最小值，用来构造一个中间的边界数组，所以说计数排序适合与数据比较小的范围，这样搞的话空间浪费还可以
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        System.out.println(String.format("max is %s", max));
        System.out.println(String.format("min is %s", min));

        //这里利用最大值、最小值的差值，构建一个小一点的数组，避免空间浪费
        int k = max - min + 1;
        int count[] = new int[k];

        //这里搞出来一个数组
        System.out.println(String.format("count array length is %s", k));
        //遍历原始数组，用每一个值减去最小的边界值，计算出这个值相当于最小值的在辅助数组的占位，有可能重复的，有可能没有占位的
        //这里做了一个某一位有啥，有几个重复的
        //这里给每一个元数组内的
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - min] += 1;
        }

        System.out.println(String.format("count array is %s", Arrays.toString(count)));

        //累加数组，元数组的值是累加数组的索引，累加数组的值是元数组的的最后一个的出现位置
        //这一步是做什么的，这里对中间数组上的值，两两相加，计算原始数组内的每一个数字在结果数组中处于的位置
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        System.out.println(String.format("count position array is %s", Arrays.toString(count)));

        //这里有进行了遍历初始数组，倒叙遍历，把每一个值放到了结果数组内
        for (int i = nums.length - 1; i >= 0; i--) {
            result[--count[nums[i] - min]] = nums[i];
            System.out.println(String.format("----- position array is %s", Arrays.toString(count)));
        }

        //返回结果
        return result;
    }


    void counting_sort(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        //找到上界和下界
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        //构建一个计数数组，遍历原数组，让值散列到计数数组内
        int[] counting = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            counting[nums[i] - min]++;
        }
        //通过计数数组，构建出来原来的数组,这里需要遍历计数数组，维护一个指针，把数据放到原来的数组内
        int j = 0;
        for (int i = 0; i < counting.length; i++) {
            while (counting[i] > 0) {
                nums[j++] = i + min;
                counting[i]--;
            }
        }
    }


}