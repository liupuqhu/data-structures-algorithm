package cn.liupu.dsa.leetcode.linkedlist;

import static cn.liupu.dsa.leetcode.linkedlist.ListNode.printList;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/2 11:48 PM
 * <p>
 * 奇数偶数链表
 * https://leetcode.com/problems/odd-even-linked-list/
 **/
public class OddEvenLinkedList {

    public static void main(String[] args) {

        ListNode head = ListNode.of(new Integer[]{6, 5, 4, 3, 2, 1});

        ListNode list = oddEvenList(head);

        printList(list);

    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }


}
