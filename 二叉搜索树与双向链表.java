题目: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    // 双向链表的左边头结点和右边头节点
    static TreeNode leftHead = null;
    static TreeNode rightHead = null;
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(8);
        TreeNode root = a;
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        TreeNode result = Convert(root);
        
    }
    public static TreeNode Convert(TreeNode pRootOfTree) {
        // 递归调用叶子节点的左右节点返回null
        if (pRootOfTree == null) {
            return null;
        }
        // 第一次运行时，它会使最左边叶子节点为链表第一个节点
        Convert(pRootOfTree.left);
        if (rightHead == null) {
            leftHead = rightHead = pRootOfTree;
        } else {
            // 把根节点插入到双向链表右边，rightHead向后移动
            rightHead.right = pRootOfTree;
            pRootOfTree.left = rightHead;
            rightHead = pRootOfTree;
        }
        // 把右叶子节点也插入到双向链表（rightHead已确定，直接插入）
        Convert(pRootOfTree.right);
        // 返回左边头结点
        return leftHead;
    }
}