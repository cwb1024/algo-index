package com.cc.algo.ext;

/**
 * 鸽巢排序（Pigeonhole Sort）适用于待排序数组的取值范围较小的情况。
 * 它的基本思想是创建一个大小等于取值范围的鸽巢数组（pigeonhole），
 * 然后将元素分配到对应的鸽巢中，最后按照顺序将鸽巢中的元素取出来。
 *
 * 时间复杂度： 在最坏情况下，鸽巢排序需要遍历整个数组并将每个元素分配到对应的鸽巢中，然后按顺序将鸽巢中的元素取出来。
 * 因此，它的时间复杂度为O(n+k)，其中 n 是数组的长度，k 是元素的取值范围
 *
 * 空间复杂度： 鸽巢排序需要额外的空间来存储鸽巢数组，其大小取决于元素的取值范围。因此，它的空间复杂度为O(k),k 是元素的取值范围。
 *
 * 需要注意的是，当元素的取值范围
 * 𝑘
 * k 远远小于数组的长度
 * 𝑛
 * n 时，鸽巢排序的时间复杂度可以近似为
 * 𝑂
 * (
 * 𝑛
 * )
 * O(n)，因为
 * 𝑘
 * k 的影响可以忽略不计。但是，当
 * 𝑘
 * k 接近
 * 𝑛
 * n 或者
 * 𝑘
 * k 较大时，鸽巢排序的性能可能会下降，因为它需要额外的空间来存储鸽巢数组。
 */
public class PigeonholeSort {

    public static void pigeonholeSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        // 找到数组中的最小值和最大值
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 计算鸽巢数组的大小
        int range = max - min + 1;
        int[] pigeonholes = new int[range];

        // 将元素分配到鸽巢中
        for (int i = 0; i < arr.length; i++) {
            pigeonholes[arr[i] - min]++;
        }

        // 按顺序将鸽巢中的元素取出来
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (pigeonholes[i] > 0) {
                arr[index++] = i + min;
                pigeonholes[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 4, 2, 8, 6, 5};
        pigeonholeSort(arr);
        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

