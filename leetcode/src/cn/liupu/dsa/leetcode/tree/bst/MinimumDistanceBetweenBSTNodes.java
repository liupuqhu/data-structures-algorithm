package cn.liupu.dsa.leetcode.tree.bst;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/31 8:52 AM
 * 783 二叉查找树任意两节点值的最小差值
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * 530 二叉查找树任意两节点的最小绝对差值(所有节点值非负)
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 **/
public class MinimumDistanceBetweenBSTNodes {

    /**
     *   4
     *  / \
     * 1   6
     *   /  \
     *   5  7
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);

        TreeNode node6 = new TreeNode(6, node5, node7);

        TreeNode node1 = new TreeNode(1);

        TreeNode root = new TreeNode(4, node1, node6);

        System.out.println(getMinimumDifference(root));
    }

    private static int minDiff = Integer.MAX_VALUE;
    private static TreeNode preNode;

    public static int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (preNode != null) minDiff = Math.min(minDiff, node.val - preNode.val);
        preNode = node;
        inOrder(node.right);
    }

}
