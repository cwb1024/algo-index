package com.cc.algo.base.sort;

import java.util.Arrays;

/**
 * @description: 基数排序，o(n*k)
 * @author: chengwb
 * @Date: 2020/4/25 20:48
 */
public class RadixSort {

    private static final int[] nums = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};

    public static void main(String[] args) {
        RadixSort process = new RadixSort();

        process.radix_sort(nums, 3);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 基数排序进行排序
     *
     * @param array
     * @return
     */
    int[] radix_sort(int[] array, int bitLength) {
        int[] result = new int[array.length];

        int[] count = new int[10];
        for (int i = 0; i < bitLength; i++) {
            int division = (int) Math.pow(10, i);

            for (int j = 0; j < array.length; j++) {
                int num = array[j] / division % 10;
                //这个位数的数值进行加1
                count[num]++;
            }

            //有了计数排序了，进行累加，保持稳定
            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j - 1];
            }

            //放到结果数组内
            for (int j = array.length - 1; j >= 0; j--) {
                int num = array[j] / division % 10;
                //这里算count的下标值
                result[--count[num]] = array[j];
            }

            //把结果数组替换为array，然后在这个稳定的基础上进行别的位数的排序,这里做一个覆盖操作
            System.arraycopy(result, 0, array, 0, array.length);
            //初始化计数数组
            Arrays.fill(count, 0);
        }
        return result;
    }
}
