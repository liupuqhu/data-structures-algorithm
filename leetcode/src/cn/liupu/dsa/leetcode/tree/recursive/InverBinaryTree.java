package cn.liupu.dsa.leetcode.tree.recursive;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/23 3:19 PM
 * 226 二叉树左右反转
 * https://leetcode.com/problems/invert-binary-tree/
 **/
public class InverBinaryTree {

    /**
     *   3
     *  / \
     * 9  20
     *   /  \
     *  15  7
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        TreeNode node20 = new TreeNode(20, node15, node7);

        TreeNode node9 = new TreeNode(9);

        TreeNode root = new TreeNode(3, node9, node20);

        root = invertTree(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

}
