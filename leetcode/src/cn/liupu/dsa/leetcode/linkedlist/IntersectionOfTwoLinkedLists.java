package cn.liupu.dsa.leetcode.linkedlist;

import static cn.liupu.dsa.leetcode.linkedlist.ListNode.printList;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/2 12:40 PM
 * <p>
 * 求两个无环单链表的相交节点
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 **/
public class IntersectionOfTwoLinkedLists {


    public static void main(String[] args) {
        //初始化链表
        ListNode c3 = new ListNode("c3");
        ListNode c2 = new ListNode("c2", c3);
        ListNode c1 = new ListNode("c1", c2);

//        ListNode d1 = new ListNode("d1");

        ListNode a2 = new ListNode("a2", c1);
        ListNode a1 = new ListNode("a1", a2);

        ListNode b3 = new ListNode("b3", c1);
        ListNode b2 = new ListNode("b2", b3);
        ListNode b1 = new ListNode("b1", b2);

        ListNode headA = a1;
        ListNode headB = b1;

        //打印原始链表
        printList(headA);
        printList(headB);

        ListNode intersectionNode = getIntersectionNode(headA, headB);

        System.out.println(intersectionNode != null ? intersectionNode.val : intersectionNode);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;

        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

}




