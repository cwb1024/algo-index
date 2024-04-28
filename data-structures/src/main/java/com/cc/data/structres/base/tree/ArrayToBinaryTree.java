package com.cc.data.structres.base.tree;

import java.util.ArrayDeque;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class ArrayToBinaryTree {

    TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }

    TreeNode buildTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        ArrayToBinaryTree process = new ArrayToBinaryTree();
        TreeNode root = process.buildTree(nums);

        System.out.println("pre_order_dfs:");
        process.pre_order_dfs(root);
        System.out.println();
        System.out.println("in_order_dfs:");
        process.in_order_dfs(root);
        System.out.println();
        System.out.println("post_order_dfs:");
        process.post_order_dfs(root);
        System.out.println();
        System.out.println("pre_order_stack:");
        process.pre_order_stack(root);
        System.out.println();
        System.out.println("in_order_stack:");
        process.in_order_stack(root);
        System.out.println();
        System.out.println("post_order_stack:");
        process.post_order_stack(root);
        System.out.println();
        System.out.println("post_order_double_stack:");
        process.post_order_double_stack(root);
        System.out.println();
        System.out.println("pre_order_Morris:");
        process.pre_order_Morris(root);
        System.out.println();
        System.out.println("in_order_stack:");
        process.in_order_stack(root);
        System.out.println();
        System.out.println("post_order_Morris:");
        process.post_order_Morris(root);
    }

    void pre_order_dfs(TreeNode root) {
        if (root == null) return;
        System.out.print(root.value + ",");
        pre_order_dfs(root.left);
        pre_order_dfs(root.right);
    }

    void in_order_dfs(TreeNode root) {
        if (root == null) return;
        in_order_dfs(root.left);
        System.out.print(root.value + ",");
        in_order_dfs(root.right);
    }

    void post_order_dfs(TreeNode root) {
        if (root == null) return;
        post_order_dfs(root.left);
        post_order_dfs(root.right);
        System.out.print(root.value + ",");
    }

    void pre_order_stack(TreeNode root) {
        if (root == null) return;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pollLast();
            System.out.print(pop.value + ",");
            if (pop.right != null) {
                stack.addLast(pop.right);
            }
            if (pop.left != null) {
                stack.addLast(pop.left);
            }
        }
    }

    void in_order_stack(TreeNode root) {
        if (root == null) return;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.addLast(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pollLast();
            System.out.print(pop.value + ",");
            if (pop.right != null) {
                cur = pop.right;
            }
        }
    }

    void post_order_stack(TreeNode root) {
        if (root == null) return;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }
            root = stack.pollLast();
            if (root.right == null || prev == root.right) {
                System.out.print(root.value + ",");
                prev = root;
                root = null;
            } else {
                stack.addLast(root);
                root = root.right;
            }
        }
    }

    void post_order_double_stack(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.addLast(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + ",");
        }
    }

    void pre_order_Morris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    System.out.print(cur1.value + ",");
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            } else {
                System.out.print(cur1.value + ",");
            }
            cur1 = cur1.right;
        }
    }

    void in_order_Morris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            //构建连接线
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            System.out.print(cur1.value + ",");
            cur1 = cur1.right;
        }
    }

    //后序Morris
    void post_order_Morris(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur1 = root;//遍历树的指针变量
        TreeNode cur2 = null;//当前子树的最右节点
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                    post_Morris_print(cur1.left);
                }
            }
            cur1 = cur1.right;
        }
        post_Morris_print(root);
    }

    //打印函数
    void post_Morris_print(TreeNode root) {
        TreeNode reverseList = post_Morris_reverseList(root);
        TreeNode cur = reverseList;
        while (cur != null) {
            System.out.print(cur.value + ",");
            cur = cur.right;
        }
        post_Morris_reverseList(reverseList);
    }

    //翻转单链表
    TreeNode post_Morris_reverseList(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            TreeNode next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
