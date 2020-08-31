package cn.liupu.dsa.leetcode.tree.bst;

/**
 * Definition for a binary tree node.
 * 树相关的31道经典算法题
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E6%A0%91.md
 * <p>
 * <p>
 * BST
 * 1. 修剪二叉查找树
 * 2. 寻找二叉查找树的第 k 个元素
 * 3. 把二叉查找树每个节点的值都加上比它大的节点的值
 * 4. 二叉查找树的最近公共祖先
 * 5. 二叉树的最近公共祖先
 * 6. 从有序数组中构造二叉查找树
 * 7. 根据有序链表构造平衡的二叉查找树
 * 8. 在二叉查找树中寻找两个节点，使它们的和为一个给定值
 * 9. 在二叉查找树中查找两个节点之差的最小绝对值
 * 10. 寻找二叉查找树中出现次数最多的值
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