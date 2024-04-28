package com.cc.algo.graph.LCA;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果树为空或者根节点等于p或q，则返回根节点
        if (root == null || root == p || root == q) {
            return root;
        }

        // 在左子树中递归查找p和q的最近公共祖先
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        // 在右子树中递归查找p和q的最近公共祖先
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // 如果左子树中找到了p和q的最近公共祖先，且右子树中也找到了，则当前节点即为最近公共祖先
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // 如果左子树中找到了p和q的最近公共祖先，则返回左子树中的结果
        if (leftLCA != null) {
            return leftLCA;
        }

        // 如果右子树中找到了p和q的最近公共祖先，则返回右子树中的结果
        return rightLCA;
    }
}

