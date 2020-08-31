package cn.liupu.dsa.leetcode.tree.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/30 5:57 PM
 * 653 BST中是否存在两个数等于制定值
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 **/
public class TwoSum4 {

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


        System.out.println(findTarget(root,11));

    }

    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);

        int i = 0;
        int j = nums.size() - 1;

        while (i < j) {
            int sum = nums.get(i) + nums.get(j);
            if (sum == k) return true;
            if (sum < k) {
                i++;
            } else {
                j--;
            }

        }
        return false;
    }

    public static void inOrder(TreeNode root,List<Integer> nums){
        if(root == null) return;
        inOrder(root.left,nums);
        nums.add(root.val);
        inOrder(root.right,nums);
    }
}
