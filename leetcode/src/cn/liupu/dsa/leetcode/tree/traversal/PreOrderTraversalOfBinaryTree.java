package cn.liupu.dsa.leetcode.tree.traversal;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/29 5:38 PM
 * 144 二叉树前序遍历(非递归方式)
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 **/
public class PreOrderTraversalOfBinaryTree {

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

        List<Integer> result = preorderTraversal(root);

        System.out.println(result);

    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node == null) continue;
            result.add(node.val);
            stack.add(node.right);
            stack.add(node.left);
        }

        return result;
    }



    /*public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }*/


}
