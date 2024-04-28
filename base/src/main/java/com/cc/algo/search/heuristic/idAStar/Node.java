package com.cc.algo.search.heuristic.idAStar;

public class Node {
    int x, y; // 节点的坐标
    int g, h; // g(n) 表示从起始节点到当前节点的代价，h(n) 表示当前节点到目标节点的估计代价

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
