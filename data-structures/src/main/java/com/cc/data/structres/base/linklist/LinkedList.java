package com.cc.data.structres.base.linklist;

public class LinkedList {

    private static final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String[] args) {
        LinkedList process = new LinkedList();
        process.buildLinkList();
    }

    void buildLinkList() {
        Node<Integer> dummyHead = new Node<>(null);
        dfs(0, dummyHead);
        Node cur = null;
        cur = dummyHead.next;
        while (cur != null) {
            System.out.print(cur.value + ",");
            cur = cur.next;
        }
    }

    void dfs(int i, Node<Integer> pre) {
        if (i == nums.length) {
            return;
        }
        Node<Integer> cur = new Node<>(i);
        pre.next = cur;
        dfs(i + 1, cur);
    }
}
