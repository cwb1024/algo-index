package com.cc.data.structres.huffmanTree;

public class HuffmanNode implements Comparable<HuffmanNode> {
    char data; // 字符
    int frequency; // 频率
    HuffmanNode left; // 左子节点
    HuffmanNode right; // 右子节点

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

    // 比较方法，根据频率进行比较
    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}
