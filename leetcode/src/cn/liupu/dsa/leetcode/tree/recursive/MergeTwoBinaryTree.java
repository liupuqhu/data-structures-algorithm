package cn.liupu.dsa.leetcode.tree.recursive;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/23 3:29 PM
 * 617 归并两棵树
 * https://leetcode.com/problems/merge-two-binary-trees/
 **/
public class MergeTwoBinaryTree {

    /**
     *  tree 1       tree 2
     *     1            4
     *    / \          / \
     *   3  2         6  7
     *  /              \  \
     * 5               8  9
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3, node5, null);

        TreeNode node2 = new TreeNode(2);

        TreeNode root1 = new TreeNode(1, node3, node2);

        TreeNode node8 = new TreeNode(8);
        TreeNode node6 = new TreeNode(6, null, node8);

        TreeNode node9 = new TreeNode(9);
        TreeNode node7 = new TreeNode(7, null, node9);

        TreeNode root2 = new TreeNode(4, node6, node7);

        TreeNode root = mergeTrees(root1, root2);
        System.out.println();

    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        int val = t1.val + t2.val;
        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        TreeNode node = new TreeNode(val, left, right);
        return node;
    }

}
