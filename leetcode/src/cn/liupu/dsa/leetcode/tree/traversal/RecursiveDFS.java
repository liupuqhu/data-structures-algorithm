package cn.liupu.dsa.leetcode.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/29 5:03 PM
 * 递归方式实现前中后序遍历
 **/
public class RecursiveDFS {

    /**
     *     1
     *    / \
     *   2   3
     *  / \   \
     * 4  5   6
     * <p>
     * 层次遍历顺序：[1 2 3 4 5 6]
     * 前序遍历顺序：[1 2 4 5 3 6]
     * 中序遍历顺序：[4 2 5 1 3 6]
     * 后序遍历顺序：[4 5 2 6 3 1]
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3, null, node6);

        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);

        TreeNode node2 = new TreeNode(2, node4, node5);

        TreeNode root = new TreeNode(1, node2, node3);

        System.out.println("层次遍历:");
        bfs(root);

        System.out.println("前序遍历:");
        preDfs(root);

        System.out.println("中序遍历:");
        midDfs(root);

        System.out.println("后序遍历:");
        postDfs(root);

        System.out.println();

    }

    public static void bfs(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            visit(node);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static void preDfs(TreeNode root) {
        if (root == null) return;
        visit(root);
        preDfs(root.left);
        preDfs(root.right);
    }

    public static void midDfs(TreeNode root) {
        if (root == null) return;
        midDfs(root.left);
        visit(root);
        midDfs(root.right);
    }

    public static void postDfs(TreeNode root) {
        if (root == null) return;
        postDfs(root.left);
        postDfs(root.right);
        visit(root);
    }

    public static void visit(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
    }

}
