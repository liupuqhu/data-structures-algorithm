package cn.liupu.dsa.leetcode.tree.traversal;

/**
 * Definition for a binary tree node.
 * 树相关的31道经典算法题
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E6%A0%91.md
 * <p>
 * <p>
 * 层次遍历
 * 1. 一棵树每层节点的平均数
 * 2. 得到左下角的节点
 * 前中后序遍历
 * 1. 非递归实现二叉树的前序遍历
 * 2. 非递归实现二叉树的后序遍历
 * 3. 非递归实现二叉树的中序遍历
 **/
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}