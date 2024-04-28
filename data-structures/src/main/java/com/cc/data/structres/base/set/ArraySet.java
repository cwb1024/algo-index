package com.cc.data.structres.base.set;

import java.util.Arrays;

public class ArraySet {
    private int[] array;
    private int size;

    public ArraySet(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    // 添加元素到set中
    public void add(int item) {
        if (!contains(item)) {
            array[size] = item;
            size++;
        }
    }

    // 从set中移除元素
    public void remove(int item) {
        int index = indexOf(item);
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }

    // 检查set中是否包含某个元素
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    // 返回set的大小
    public int size() {
        return size;
    }

    // 获取set的元素数组
    public int[] elements() {
        return Arrays.copyOf(array, size);
    }

    // 返回元素在数组中的索引，如果不存在则返回-1
    private int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArraySet set = new ArraySet(5);

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); // 重复值不会被添加

        System.out.println("Contains 1: " + set.contains(1)); // true
        System.out.println("Contains 4: " + set.contains(4)); // false

        set.remove(2);

        System.out.println("Size: " + set.size()); // 2

        int[] elements = set.elements();
        System.out.println("Elements: " + Arrays.toString(elements)); // [1, 3]
    }
}

