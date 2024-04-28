package com.cc.data.structres.base.linklist;

/**
 * @description: 链表的节点
 * @author: chengwb
 * @Date: 2020/4/27 00:30
 */
public class Node<T> {

    /**
     * 节点内容
     */
    T value;
    /**
     * 下一个节点
     */
    Node next;

    public Node() {}

    public Node(T value) {
        this.value = value;
        this.next = null;
    }
}
