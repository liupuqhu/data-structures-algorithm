//Given a binary tree, return all root-to-leaf paths.
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// 
//Input:
//
//   1
// /   \
//2     3
// \
//  5
//
//Output: ["1->2->5", "1->3"]
//
//Explanation: All root-to-leaf paths are: 1->2->5, 1->3
// Related Topics Tree Depth-first Search 
// 👍 2194 👎 120


package cn.liupu.dsa.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();

        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t15 = new TreeNode(15, null, null);

        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t9 = new TreeNode(9, null, null);

        TreeNode root = new TreeNode(3, t9, t20);

        List<String> list = solution.binaryTreePaths(root);

        System.out.println(list);
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
        public List<String> binaryTreePaths(TreeNode root) {

            List<String> list = new ArrayList<>();
            path(root, list, new StringBuilder());
            return list;
        }

        private void path(TreeNode root, List<String> list, StringBuilder sb) {
            if (root != null) {
                sb.append(root.val);
                int len = sb.length();

                if (root.left == null && root.right == null) {
                    list.add(sb.toString());
                } else {
                    path(root.left, list, sb.append("->"));
                    sb.delete(len, sb.length());
                    path(root.right, list, sb.append("->"));
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}