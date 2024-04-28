package com.cc.algo.trie.ipRouteTable;

public class IPRouteTable {
    private TrieNode root;

    public IPRouteTable() {
        this.root = new TrieNode();
    }

    // 添加路由信息
    public void addRoute(String ipAddress, String route) {
        TrieNode current = root;
        for (char ch : ipAddress.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
        current.route = route;
    }

    // 查找IP地址对应的路由信息
    public String findRoute(String ipAddress) {
        TrieNode current = root;
        for (char ch : ipAddress.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return null; // 没有匹配的路由信息
            }
            current = current.children.get(ch);
        }
        return current.route; // 返回匹配的路由信息
    }

    public static void main(String[] args) {
        IPRouteTable routeTable = new IPRouteTable();
        routeTable.addRoute("192.168.1.0", "Gateway 1");
        routeTable.addRoute("192.168.2.0", "Gateway 2");
        routeTable.addRoute("10.0.0.0", "Gateway 3");

        String route1 = routeTable.findRoute("192.168.1.100");
        System.out.println("Route for 192.168.1.100: " + route1);

        String route2 = routeTable.findRoute("10.0.0.1");
        System.out.println("Route for 10.0.0.1: " + route2);

        String route3 = routeTable.findRoute("192.168.3.10");
        System.out.println("Route for 192.168.3.10: " + route3);
    }
}
