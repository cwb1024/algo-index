package com.cc.algo.ac;

import java.util.*;

public class AhoCorasick {

    static class Node {
        Map<Character, Node> children;
        Node parent;
        Node fail; // 失败指针
        boolean isEnd;

        public Node() {
            children = new HashMap<>();
            parent = null;
            fail = null;
            isEnd = false;
        }
    }

    static class AC {
        Node root;

        public AC() {
            root = new Node();
        }

        // 插入模式串
        void insert(String pattern) {
            Node current = root;
            for (char c : pattern.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new Node());
                    current.children.get(c).parent = current;
                }
                current = current.children.get(c);
            }
            current.isEnd = true;
        }

        // 构建失败指针
        void buildFailPointer() {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                for (char c : current.children.keySet()) {
                    Node next = current.children.get(c);
                    if (current == root) {
                        next.fail = root;
                    } else {
                        Node temp = current.fail;
                        while (temp != null) {
                            if (temp.children.containsKey(c)) {
                                next.fail = temp.children.get(c);
                                break;
                            }
                            temp = temp.fail;
                        }
                        if (temp == null) {
                            next.fail = root;
                        }
                    }
                    queue.offer(next);
                }
            }
        }

        // 匹配文本中的模式串
        void match(String text) {
            Node current = root;
            for (char c : text.toCharArray()) {
                while (current != root && !current.children.containsKey(c)) {
                    current = current.fail;
                }
                if (current.children.containsKey(c)) {
                    current = current.children.get(c);
                }
                if (current.isEnd) {
                    System.out.println("Pattern found");
                }
            }
        }
    }

    public static void main(String[] args) {
        AC ac = new AC();
        String[] patterns = {"he", "she", "his", "hers"};
        for (String pattern : patterns) {
            ac.insert(pattern);
        }
        ac.buildFailPointer();
        String text = "hishers";
        ac.match(text);
    }
}

