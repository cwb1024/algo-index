package com.cc.algo.search.heuristic.astar;

// 表示一个节点
public class Node {
    int x, y; // 节点的坐标
    int f, g, h; // f(n) = g(n) + h(n)，分别表示总代价、起始节点到当前节点的代价、当前节点到目标节点的估计代价
    Node parent; // 指向父节点

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
