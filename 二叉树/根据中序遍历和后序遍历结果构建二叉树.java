思路: 先确定根节点，然后通过根节点的值确定其在中序遍历的位置，
从而知道其左右子树的元素以及个数，再通过递归的方式分别构建走右子树


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

    public static void main(String[] args) {
       int[] inorder = new int[] {4, 2, 5, 1, 6, 3, 7};
       int[] postorder = new int[] {4, 5, 2, 6, 7, 3, 1};
       TreeNode root = buildTree(inorder, postorder);
       preOrder(root);
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        // 辅助函数
        TreeNode root = buildTree(inorder, 0, inorder.length - 1,
                                    postorder, 0, postorder.length - 1);
        return root;
    }

    public static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        // 递归出口
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        // 创建根节点, 根节点一定是后序遍历结果的最后一个元素
        TreeNode root = new TreeNode(postorder[postEnd]);
        // 获取根节点在中序遍历的位置
        int rootIndex = findRoot(inorder, postorder[postEnd]);
        // 创建左子树
        root.left = buildTree(inorder, inStart, rootIndex - 1,
                        postorder, postStart, postStart + (rootIndex - inStart- 1));
        // 创建右子树
        root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder,
                    postStart + (rootIndex - inStart), postEnd - 1);
        return root;
    }

    // 在中序遍历中找到根节点的位置，以确定其左右子树的元素
    private static int findRoot(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
}