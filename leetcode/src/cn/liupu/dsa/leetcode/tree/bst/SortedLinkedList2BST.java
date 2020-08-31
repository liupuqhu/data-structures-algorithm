package cn.liupu.dsa.leetcode.tree.bst;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/30 5:27 PM
 * 109 有序链表构造平衡二叉查找树
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 **/
public class SortedLinkedList2BST {

    public static void main(String[] args) {

        //构造单链表
        ListNode node5 = new ListNode(9);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(0, node4);
        ListNode node2 = new ListNode(-3, node3);
        ListNode node1 = new ListNode(-10, node2);

        ListNode head = node1;

        TreeNode root = sortedListToBST(head);

        System.out.println();
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;

        preMid.next = null;

        TreeNode node = new TreeNode(mid.val);
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);

        return node;
    }

    private static ListNode preMid(ListNode head) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }

}
