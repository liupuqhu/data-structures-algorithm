package cn.liupu.dsa.nowcoder.top200;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/7 9:23 下午
 **/
public class NC45_BinaryTreeTraversal {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);

        NC45_BinaryTreeTraversal demo = new NC45_BinaryTreeTraversal();
        int[][] results = demo.threeOrders(root);
    }

    public int[][] threeOrders(TreeNode root) {
        List<Integer> preOrderList = preOrderTraversal(root);
        List<Integer> inOrderList = inOrderTraversal(root);
        List<Integer> postOrderList = postOrderTraversal(root);
        int[][] results = new int[3][];
        results[0] = list2intArray(preOrderList);
        results[1] = list2intArray(inOrderList);
        results[2] = list2intArray(postOrderList);
        System.out.println("pre order list : " + Arrays.toString(results[0]));
        System.out.println("in order list : " + Arrays.toString(results[1]));
        System.out.println("post order list : " + Arrays.toString(results[2]));
        return results;
    }


    private List<Integer> levelTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            result.add(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if(node.right != null){
                queue.addLast(node.right);
            }
        }
        return result;
    }


    private List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            result.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }

        Collections.reverse(result);
        return result;
    }

    private List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            cur = node.right;
        }

        return result;
    }

    private List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            stack.push(node.right);
            stack.push(node.left);
            result.add(node.val);
        }
        return result;
    }

    private int[] list2intArray(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


}
