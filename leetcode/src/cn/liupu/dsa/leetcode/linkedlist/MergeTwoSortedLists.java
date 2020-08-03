package cn.liupu.dsa.leetcode.linkedlist;

import static cn.liupu.dsa.leetcode.linkedlist.ListNode.printList;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/2 2:10 PM
 * <p>
 * 归并两个有序链表
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 **/
public class MergeTwoSortedLists {

    public static void main(String[] args) {

        //初始化链表
        ListNode c3 = new ListNode("c3");
        ListNode c2 = new ListNode("c2", c3);
        ListNode c1 = new ListNode("c1", c2);

        ListNode a2 = new ListNode("a2", c1);
        ListNode a1 = new ListNode("a1", a2);


        ListNode b3 = new ListNode("b3");
        ListNode b2 = new ListNode("b2", b3);
        ListNode b1 = new ListNode("b1", b2);
        ListNode a4 = new ListNode("a2", b1);
        ListNode a3 = new ListNode("a1", a4);

        ListNode l1 = a1;
        ListNode l2 = a3;

        //打印原始链表
        printList(l1);
        printList(l2);

        ListNode listNode = mergeTwoLists(l1, l2);
        printList(listNode);

    }

    public static ListNode mergeTwoLists(ListNode<String> l1, ListNode<String> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val.compareTo(l2.val) < 0) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }


}
