package cn.liupu.dsa.leetcode.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/29 4:45 PM
 * 513 寻找二叉树底层最左侧节点
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 **/
public class BottomLeftTreeValue {

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

        System.out.println(findBottomLeftValue(root));


        System.out.println();

    }

    public static int findBottomLeftValue(TreeNode root) {
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);

       while(!queue.isEmpty()){
           root = queue.poll();
           if(root.right != null) queue.add(root.right);
           if(root.left != null) queue.add(root.left);
       }

       return root.val;
    }


    /*public static int findBottomLeftValue(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = root.val;

        while (!queue.isEmpty()) {
            boolean firstFlag = true;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (firstFlag) {
                    result = node.val;
                    firstFlag = false;
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

        }

        return result;
    }*/
}
