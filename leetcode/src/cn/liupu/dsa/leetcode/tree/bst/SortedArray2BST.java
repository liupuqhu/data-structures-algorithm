package cn.liupu.dsa.leetcode.tree.bst;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/30 5:14 PM
 * 108 有序数组构造平衡二叉查找树
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 **/
public class SortedArray2BST {

    public static void main(String[] args) {

        int[] nums = new int[]{-10, -3, 0, 5, 9};

        TreeNode root = sortedArrayToBST(nums);

        System.out.println();

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int sIndex, int eIndex) {
        if (sIndex > eIndex) return null;
        int midIndex = (sIndex + eIndex) / 2;
        TreeNode node = new TreeNode(nums[midIndex]);
        node.left = sortedArrayToBST(nums, sIndex, midIndex - 1);
        node.right = sortedArrayToBST(nums, midIndex + 1, eIndex);
        return node;
    }


}


