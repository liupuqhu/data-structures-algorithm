package cn.liupu.dsa.leetcode.tree.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/31 9:10 AM
 * 501 二叉查找树中查询出现最多次数的元素
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 **/
public class FindModeInBST {

    /**
     *   4
     *  / \
     * 1   6
     *   /  \
     *   5  6
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node5 = new TreeNode(6);
        TreeNode node4 = new TreeNode(5);

        TreeNode node3 = new TreeNode(6, node4, node5);

        TreeNode node2 = new TreeNode(4);

        TreeNode root = new TreeNode(4, node2, node3);

        int[] result = findMode(root);
        System.out.println(Arrays.toString(result));
    }

    private static int curCount = 1;
    private static int maxCount = 1;

    private static TreeNode preNode;

    public static int[] findMode(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int[] result = new int[nums.size()];
        int i = 0;
        for (int num : nums) {
            result[i++] = num;
        }
        return result;
    }

    private static void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null) return;
        inOrder(node.left, nums);
        if (preNode != null) {
            if (node.val == preNode.val) {
                curCount++;
            } else {
                curCount = 1;
            }
        }

        if (curCount > maxCount) {
            maxCount = curCount;
            nums.clear();
            nums.add(node.val);
        } else if (curCount == maxCount) {
            nums.add(node.val);
        }
        preNode = node;
        inOrder(node.right, nums);
    }

}
