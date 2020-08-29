package cn.liupu.dsa.leetcode.tree.recursive;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/23 4:10 PM
 * 437 二叉树路径和等于指定值的路径数
 * https://leetcode.com/problems/path-sum-iii/
 **/
public class PathSum3 {

    /**
     *      3
     *    /  \
     *   9    4
     *  /    / \
     * 2    5  7
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);

        TreeNode node4 = new TreeNode(4, node5, node7);

        TreeNode node2 = new TreeNode(2);
        TreeNode node9 = new TreeNode(9, node2, null);

        TreeNode root = new TreeNode(3, node9, node4);

        System.out.println(pathSum(root, 11));

    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) return 0;
        int ret = 0;
        if (root.val == sum) ret++;
        ret += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);
        return ret;
    }

}
