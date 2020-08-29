package cn.liupu.dsa.leetcode.tree.recursive;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/27 8:33 AM
 * <p>
 * 404 左叶子节点之和
 * https://leetcode.com/problems/sum-of-left-leaves/
 **/
public class SumOfLeftLeaves {

    /**
     * 3
     * / \
     * 9  20
     * /  \
     * 15  7
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        TreeNode node20 = new TreeNode(20, node15, node7);

        TreeNode node9 = new TreeNode(9);

        TreeNode root = new TreeNode(3, node9, node20);

        System.out.println(sumOfLeftLeaves(root));
    }


    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private static boolean isLeaf(TreeNode node) {
        if (node == null) return false;
        if (node.left == null && node.right == null) return true;
        return false;
    }
}
