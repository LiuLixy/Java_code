Given a binary tree, find its minimum depth. The minimum depth is 
the number of nodes along the shortest path from the root node 
down to the nearest leaf node.

package com.lwstudy.BalancedTree;

class TreeNode {
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode left = null;
    TreeNode right = null;
}

public class Main {
    private static boolean isBalanced = true;

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode root = a;
        a.right = b;
        b.left = c;
        b.left = d;
        c.right = e;
        System.out.println(run(root));
    }
    public static int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return run(root.right) + 1;
        }
        if (root.right == null) {
            return run(root.left) + 1;
        }
        return Math.min(run(root.left), run(root.right)) + 1;
    }
}