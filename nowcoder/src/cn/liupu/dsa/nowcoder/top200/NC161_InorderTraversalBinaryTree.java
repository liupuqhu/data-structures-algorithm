package cn.liupu.dsa.nowcoder.top200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/4/18 7:17 下午
 **/
public class NC161_InorderTraversalBinaryTree {

    public static void main(String[] args) {

        TreeNode left = new TreeNode(2, null, null);
        TreeNode right = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, left, right);

        int[] result = inorderTraversal(root);

        System.out.println(Arrays.toString(result));

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public static int[] inorderTraversal(TreeNode root) {
        // write code here

        List<Integer> list = new ArrayList<>();

        traversal(root, list);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    static void traversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traversal(node.left, list);
        list.add(node.val);
        traversal(node.right, list);
    }


    

}



