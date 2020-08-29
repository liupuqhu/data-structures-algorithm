package cn.liupu.dsa.leetcode.tree;

/**
 * Definition for a binary tree node.
 * 树相关的31道经典算法题
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E6%A0%91.md
 * <p>
 * <p>
 * 递归
 * 1. 树的高度
 * 2. 平衡树
 * 3. 两节点的最长路径
 * 4. 翻转树
 * 5. 归并两棵树
 * 6. 判断路径和是否等于一个数
 * 7. 统计路径和等于一个数的路径数量
 * 8. 子树
 * 9. 树的对称
 * 10. 最小路径
 * 11. 统计左叶子节点的和
 * 12. 相同节点值的最大路径长度
 * 13. 间隔遍历
 * 14. 找出二叉树中第二小的节点
 * 层次遍历
 * 1. 一棵树每层节点的平均数
 * 2. 得到左下角的节点
 * 前中后序遍历
 * 1. 非递归实现二叉树的前序遍历
 * 2. 非递归实现二叉树的后序遍历
 * 3. 非递归实现二叉树的中序遍历
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
 * Trie
 * 1. 实现一个 Trie
 * 2. 实现一个 Trie，用来求前缀和
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