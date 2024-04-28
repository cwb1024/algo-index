package com.cc.data.structres.huffmanTree;

import java.util.PriorityQueue;

public class HuffmanTree {
    // 构建霍夫曼树
    public static HuffmanNode buildHuffmanTree(int[] frequencies, char[] characters) {
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();
        // 将所有字符的频率作为叶子节点加入最小堆
        for (int i = 0; i < frequencies.length; i++) {
            HuffmanNode node = new HuffmanNode(characters[i], frequencies[i]);
            minHeap.offer(node);
        }
        // 不断合并最小频率的两个节点，直到堆中只剩一个节点
        while (minHeap.size() > 1) {
            HuffmanNode left = minHeap.poll();
            HuffmanNode right = minHeap.poll();
            HuffmanNode parent = new HuffmanNode('-', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            minHeap.offer(parent);
        }
        return minHeap.poll();
    }

    // 打印霍夫曼树的编码
    public static void printCodes(HuffmanNode root, String code) {
        if (root == null) return;
        // 如果是叶子节点，打印字符和编码
        if (root.left == null && root.right == null) {
            System.out.println(root.data + ": " + code);
        }
        // 向左子树递归，编码加上0
        printCodes(root.left, code + "0");
        // 向右子树递归，编码加上1
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        char[] characters = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] frequencies = {5, 9, 12, 13, 16, 45};

        // 构建霍夫曼树
        HuffmanNode root = buildHuffmanTree(frequencies, characters);

        // 打印霍夫曼树的编码
        printCodes(root, "");
    }
}
