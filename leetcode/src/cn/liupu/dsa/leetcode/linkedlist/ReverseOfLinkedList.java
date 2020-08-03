package cn.liupu.dsa.leetcode.linkedlist;

import static cn.liupu.dsa.leetcode.linkedlist.ListNode.printList;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/2 1:02 PM
 * <p>
 * 单链表反转
 * https://leetcode.com/problems/reverse-linked-list/description/
 **/
public class ReverseOfLinkedList {

    public static void main(String[] args) {

        //初始化链表
        ListNode c3 = new ListNode("c3");
        ListNode c2 = new ListNode("c2", c3);
        ListNode c1 = new ListNode("c1", c2);

        ListNode a2 = new ListNode("a2", c1);
        ListNode a1 = new ListNode("a1", a2);

        ListNode head = a1;

        printList(head);

//        ListNode reversedRecursiveList = reverseListRecursive(head);
//        printList(reversedRecursiveList);

        ListNode reversedList = reverseList(head);
        printList(reversedList);


    }

    private static ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode("");
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;

        ListNode newHead = reverseListRecursive(next);
        next.next = head;
        head.next = null;

        return newHead;
    }

}





