package cn.liupu.dsa.leetcode.tree.recursive;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/23 4:41 PM
 * 572 判断一棵树是否是另一棵树的子树
 * https://leetcode.com/problems/subtree-of-another-tree/
 **/
public class SubTreeOfAnotherTree {

    /**
     *  tree s
     *     3
     *    / \
     *   4  5
     *  / \
     * 1  2
     *
     *  tree t
     *    4
     *   / \
     *  1  2
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        TreeNode node4 = new TreeNode(4, node1, node2);

        TreeNode node5 = new TreeNode(5);

        TreeNode s = new TreeNode(3, node4, node5);

        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(2);

        TreeNode t = new TreeNode(4, node21, node22);

        boolean result = isSubtree(s,t);
        System.out.println(result);

    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (isEqualTree(s, t)) return true;
        if (s == null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static boolean isEqualTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isEqualTree(s.left, t.left) && isEqualTree(s.right, t.right);
    }
}
