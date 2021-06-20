//Given a binary tree, return the bottom-up level order traversal of its nodes'
//values. (ie, from left to right, level by level from leaf to root). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its bottom-up level order traversal as: 
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics Tree Breadth-first Search 
// 👍 1849 👎 231


package cn.liupu.dsa.leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();

        TreeNode t7 = new TreeNode(7,null,null);
        TreeNode t15 = new TreeNode(15,null,null);

        TreeNode t20 = new TreeNode(20,t15,t7);
        TreeNode t9 = new TreeNode(9,null,null);

        TreeNode root = new TreeNode(3,t9,t20);

        List<List<Integer>> lists = solution.levelOrderBottom(root);

        System.out.println();


    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            List<List<Integer>> resultList = new ArrayList<>();

            Queue<TreeNode> list = new LinkedList<>();

            List<Integer> tmpList = new ArrayList<>();

            list.add(root);
            list.add(null);

            while (!list.isEmpty()) {
                TreeNode node = list.poll();
                if (node != null) {
                    tmpList.add(node.val);
                    if (node.left != null) {
                        list.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right);
                    }
                } else {
                    if (tmpList.isEmpty()) {
                        break;
                    }
                    resultList.add(tmpList);
                    tmpList = new ArrayList<>();
                    list.add(null);
                }
            }

            int size = resultList.size();
            for (int i = 0; i < size / 2; i++) {
                List<Integer> tmp = resultList.get(i);
                resultList.set(i, resultList.get(size - 1 - i));
                resultList.set(size - 1 - i, tmp);
            }

            return resultList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

