题目: 判断一棵树是否为平衡二叉树

平衡二叉树的定义: 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
并且左右两个子树都是一棵平衡二叉树。

思路: 先判断左右子树的高度差的绝对值是否不超过1，
然后再递归的对每一棵子树进行相同的判定

代码实现:
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
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode root = a;
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        System.out.println(IsBalanced_Solution(root));
    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        boolean booleft = IsBalanced_Solution(root.left);
        boolean booright = IsBalanced_Solution(root.right);
        return booleft && booright;
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return left > right ? left + 1 : right + 1;
    }
}