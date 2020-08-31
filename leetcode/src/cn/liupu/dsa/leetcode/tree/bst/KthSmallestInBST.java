package cn.liupu.dsa.leetcode.tree.bst;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/30 2:21 PM
 * 230 二叉树中第K小元素
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 **/
public class KthSmallestInBST {

    /**
     *    3
     *  /  \
     * 0   4
     *  \
     *   2
     *  /
     * 1
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, null);

        TreeNode node0 = new TreeNode(0, null, node2);

        TreeNode node4 = new TreeNode(4);

        TreeNode root = new TreeNode(3, node0, node4);


        System.out.println(kthSmallest(root,3));
    }

    //求节点个数(递归方式)
    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        int leftCount = count(root.left);
        if (leftCount == k - 1) return root.val;
        if (leftCount > k - 1) return kthSmallest(root.left, k);
        return kthSmallest(root.right, k - leftCount - 1);
    }

    public static int count(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }


    //中序遍历递归方式
    /*private static int count = 0;
    private static int val;

    public static int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    public static void inOrder(TreeNode root, int k) {
        if (root == null) return;
        inOrder(root.left, k);
        count++;
        if (count == k) {
            val = root.val;
            return;
        }
        inOrder(root.right, k);
    }*/

    //中序遍历非递归方式
    /*public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            count++;
            if (count == k) {
                return node.val;
            }
            cur = node.right;

        }

        return Integer.MIN_VALUE;
    }
*/


}
