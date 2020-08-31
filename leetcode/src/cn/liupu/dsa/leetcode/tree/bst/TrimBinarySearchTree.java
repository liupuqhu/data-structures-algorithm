package cn.liupu.dsa.leetcode.tree.bst;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/30 2:06 PM
 * 669 修剪二叉查找树
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 **/
public class TrimBinarySearchTree {

    /**
     *    3
     *  /  \
     * 0   4
     *  \
     *   2
     *  /
     * 1
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, null);

        TreeNode node0 = new TreeNode(0, null, node2);

        TreeNode node4 = new TreeNode(4);

        TreeNode root = new TreeNode(3, node0, node4);

        TreeNode node = trimBST(root,1,3);
        System.out.println();

    }

    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }

}
