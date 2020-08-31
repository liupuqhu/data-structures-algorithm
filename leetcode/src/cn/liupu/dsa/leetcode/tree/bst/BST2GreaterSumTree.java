package cn.liupu.dsa.leetcode.tree.bst;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/30 3:54 PM
 * 538 二叉查找树切换成数值更大的树
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * 1038 二叉查找树转换成更大数值和的树
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 *
 **/
public class BST2GreaterSumTree {

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

        convertBST(root);

        System.out.println();

    }

    private static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        traver(root);
        return root;
    }

    private static void traver(TreeNode node) {
        if (node == null) return;
        traver(node.right);
        sum += node.val;
        node.val = sum;
        traver(node.left);
    }


    //非递归中序遍历(RDL)
   /* private static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            TreeNode node = stack.pop();
            sum += node.val;
            node.val = sum;
            cur = node.left;
        }

        return root;
    }*/
}
