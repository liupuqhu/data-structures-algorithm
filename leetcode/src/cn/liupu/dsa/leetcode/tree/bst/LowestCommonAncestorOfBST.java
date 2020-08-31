package cn.liupu.dsa.leetcode.tree.bst;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/30 4:31 PM
 * 235 二叉查找树中两节点的最近祖先节点
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 **/
public class LowestCommonAncestorOfBST {

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

        TreeNode node = lowestCommonAncestor(root, node5, node7);

        System.out.println(node.val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
