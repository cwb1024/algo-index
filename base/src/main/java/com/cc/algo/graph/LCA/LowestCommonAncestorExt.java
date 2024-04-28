package com.cc.algo.graph.LCA;

class TreeNodeExt {
    int val;
    TreeNodeExt left;
    TreeNodeExt right;
    TreeNodeExt parent; // 父节点
    int depth; // 深度

    TreeNodeExt(int x) {
        val = x;
    }
}

public class LowestCommonAncestorExt {
    // 预处理树，为每个节点存储父节点和深度信息
    private void preprocess(TreeNodeExt root, TreeNodeExt parent, int depth) {
        if (root == null) {
            return;
        }
        root.parent = parent;
        root.depth = depth;
        preprocess(root.left, root, depth + 1);
        preprocess(root.right, root, depth + 1);
    }

    // 计算节点p和节点q的最近公共祖先
    public TreeNodeExt lowestCommonAncestor(TreeNodeExt root, TreeNodeExt p, TreeNodeExt q) {
        preprocess(root, null, 0); // 预处理树

        // 将深度较大的节点上移至与深度较小的节点同一深度
        while (p.depth > q.depth) {
            p = p.parent;
        }
        while (q.depth > p.depth) {
            q = q.parent;
        }

        // 同时向上移动节点p和节点q，直到找到最近公共祖先
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }

        return p; // 返回最近公共祖先
    }
}

