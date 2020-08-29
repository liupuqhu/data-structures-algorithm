package cn.liupu.dsa.leetcode.tree.recursive;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/29 11:51 AM
 * 671 找出二叉树中第二小的节点
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 **/
public class SecondMinimumValue {

    /**
     *      2
     *    /  \
     *   2    5
     *       / \
     *      5  7
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node3 = new TreeNode(5, node4, node5);

        TreeNode node2 = new TreeNode(2);
        TreeNode root = new TreeNode(2, node2, node3);

        System.out.println(findSecondMinimumValue(root));

    }

    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return -1;
        int leftValue = root.left.val;
        int rightValue = root.right.val;

        if (leftValue == root.val) leftValue = findSecondMinimumValue(root.left);
        if (rightValue == root.val) rightValue = findSecondMinimumValue(root.right);

        if (leftValue != -1 && rightValue != -1) return Math.min(leftValue, rightValue);
        if (leftValue != -1) return leftValue;
        return rightValue;
    }


}
