package cn.liupu.dsa.leetcode.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/29 1:24 PM
 * 637 二叉树层的平均值
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 **/
public class AverageOfLevels {

    /**
     *   3
     *  / \
     * 9  20
     *   /  \
     *  15  7
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        TreeNode node20 = new TreeNode(20, node15, node7);

        TreeNode node9 = new TreeNode(9);

        TreeNode root = new TreeNode(3, node9, node20);

        List<Double> result = averageOfLevels(root);
        System.out.println(result);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            double sum = 0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(sum / count);
        }

        return result;
    }

}
