package cn.liupu.dsa.nowcoder.top200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/28 11:19 上午
 **/
public class NC102_LowestCommonAncestorOfBinaryTree {

    public static void main(String[] args) {

        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);

        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);

        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);

        TreeNode root = new TreeNode(1, node2, node3);

        NC102_LowestCommonAncestorOfBinaryTree demo = new NC102_LowestCommonAncestorOfBinaryTree();

//        System.out.println(demo.isAncestor(node2, 7));
        System.out.println(demo.lowestCommonAncestor(root, 9, 10));
        System.out.println(demo.lowestCommonAncestor2(root, 9, 10));

    }

    public int lowestCommonAncestor2(TreeNode root, int o1, int o2) {
        return commonAncestor(root, o1, o2).val;
    }

    private TreeNode commonAncestor(TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2) {
            return root;
        }
        TreeNode left = commonAncestor(root.left, o1, o2);
        TreeNode right = commonAncestor(root.right, o1, o2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (isAncestor(node, o1) && isAncestor(node, o2)) {
                result = node.val;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    public boolean isAncestor(TreeNode node, int num) {
        if (node == null) {
            return false;
        }

        if (node.val == num) {
            return true;
        }
        return isAncestor(node.left, num) || isAncestor(node.right, num);
    }
}
