给定一个二叉树，判定其是否为二叉搜索树。

二叉搜索树定义：二叉搜索树是一颗二叉树，树中的每一个节点的值都是大于
其左子树的值小于其右子树的值，而且其每一棵子树都是一颗二叉搜索树，
其中序遍历结果是从小到大依次排列的。 

思路： 根据其中序遍历结果为递增的，于是可以先得到这棵二叉树的中序
遍历结果，再判定中序遍历是否为递增的，从而判断其是否为二叉搜索树。

package com.lwstudy.binarysearchtree;

import java.util.ArrayList;

class TreeNode {
    public int val;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode root = b;
        root.left = a;
        root.right = d;
        d.left = c;
        d.right = e;
        System.out.println(isValidBST(root));
    }
    public static void inOrder(TreeNode root, ArrayList<Integer> arrayList) {
        if (root == null) {
            return;
        }
        inOrder(root.left, arrayList);
        arrayList.add(root.val);
        inOrder(root.right, arrayList);
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        inOrder(root, arrayList);
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i) >= arrayList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}