package cn.liupu.dsa.leetcode.tree.recursive;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/27 8:53 AM
 *
 * 687 相同节点值的最大路径长度
 * https://leetcode.com/problems/longest-univalue-path/
 **/
public class LongestUnivaluePath {

    /**
     *   5
     *  / \
     * 9   5
     *   /  \
     *  15  5
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(5);

        TreeNode node3 = new TreeNode(5, node4, node5);

        TreeNode node2 = new TreeNode(9);

        TreeNode root = new TreeNode(5, node2, node3);

        System.out.println(longestUnivaluePath(root));

    }

    private static int path = 0;

    public static int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return path;
    }

    private static int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        int leftPath = root.left != null && root.left.val == root.val ? 1 + left : 0;
        int rightPath = root.right != null && root.right.val == root.val ? 1 + right : 0;

        path = Math.max(path, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }



    // 一种直观但是低效的尝试方式

    /*private static int path = 0;

    public static int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        path = univaluePath(root);
        //todo 遍历二叉树依次比较,求出最大路径长度
        return path;
    }

    private static int univaluePath(TreeNode node){
        if(node == null) return 0;
        if(isLeftEqual(node) && isRightEqual(node)){
            return 1 + univaluePath(node.left) + 1 + univaluePath(node.right);
        }
        if(isLeftEqual(node)){
            return 1 + univaluePath(node.left);
        }
        if(isRightEqual(node)){
            return 1 + univaluePath(node.right);
        }
        return 0;
    }

    private static boolean isLeftEqual(TreeNode node){
        if(node == null) return false;
        if(node.left == null) return false;
        if(node.val != node.left.val) return false;
        return true;
    }

    private static boolean isRightEqual(TreeNode node){
        if(node == null) return false;
        if(node.right == null) return false;
        if(node.val != node.right.val) return false;
        return true;
    }*/
}
