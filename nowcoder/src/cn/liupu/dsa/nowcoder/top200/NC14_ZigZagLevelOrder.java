package cn.liupu.dsa.nowcoder.top200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/26 9:17 下午
 **/
public class NC14_ZigZagLevelOrder {

    public static void main(String[] args) {
        NC14_ZigZagLevelOrder demo = new NC14_ZigZagLevelOrder();

        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode left = new TreeNode(2, node4, node5);
        TreeNode right = new TreeNode(3, node6, node7);
        TreeNode root = new TreeNode(1, left, right);

        ArrayList<ArrayList<Integer>> lists = demo.zigzagLevelOrder(root);
        System.out.println();
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (count % 2 == 0) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
            }
            result.add(list);
            count++;
        }
        return result;
    }

}
