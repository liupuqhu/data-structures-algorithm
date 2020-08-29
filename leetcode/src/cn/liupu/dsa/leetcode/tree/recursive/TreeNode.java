package cn.liupu.dsa.leetcode.tree.recursive;

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
 *
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