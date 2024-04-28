package com.cc.data.structres.base.adjacencyList;

import java.util.LinkedList;
public class GraphNode {
    int vertex;
    LinkedList<Integer> neighbors;

    public GraphNode(int vertex) {
        this.vertex = vertex;
        this.neighbors = new LinkedList<>();
    }
}
