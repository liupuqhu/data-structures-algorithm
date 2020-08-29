package cn.liupu.dsa.leetcode.tree.recursive;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/23 2:35 PM
 * 110 是否是平衡二叉树
 * https://leetcode.com/problems/balanced-binary-tree/
 **/
public class BalancedBinaryTreeCheck {

    private static boolean result = true;

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

        boolean isBalanced = isBalanced(root);
        System.out.println(isBalanced);

    }

    public static boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }


    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1) result = false;
        return 1 + Math.max(l, r);
    }
}
