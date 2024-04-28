package com.cc.data.structres.base.hash;

import java.util.LinkedList;

public class SimpleMap<K, V> {
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    // Map的Entry类
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // 构造函数，初始化buckets数组
    public SimpleMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    // 添加键值对
    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // 如果已存在相同的key，则更新value
                return;
            }
        }
        bucket.add(new Entry<>(key, value)); // 如果不存在相同的key，则添加新的Entry
        size++;
    }

    // 根据键查找值
    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // 未找到对应的key，返回null
    }

    // 删除键值对
    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    // 获取Map的大小
    public int size() {
        return size;
    }

    // 根据键计算存储桶的索引
    private int getIndex(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public static void main(String[] args) {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("orange", 30);

        System.out.println("Value of 'apple': " + map.get("apple")); // 10
        System.out.println("Value of 'banana': " + map.get("banana")); // 20
        System.out.println("Value of 'grape': " + map.get("grape")); // null

        map.remove("banana");
        System.out.println("Size after removing 'banana': " + map.size()); // 2
    }
}

