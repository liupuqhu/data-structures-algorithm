package cn.liupu.dsa.leetcode.tree.recursive;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/3 9:12 PM
 * 104 二叉树的最大深度
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 **/
public class MaxDepthOfTree {

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

        int maxDepth = maxDepth(root);
        System.out.println(maxDepth);

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
