package cn.liupu.dsa.leetcode.linkedlist;

import static cn.liupu.dsa.leetcode.linkedlist.ListNode.printList;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/2 2:48 PM
 * <p>
 * 删除链表倒数第N个节点
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 **/
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {

        ListNode head = ListNode.of(new String[]{"5", "4", "3", "2", "1"});
        printList(head);

        ListNode newHead = removeNthNode(head, 6);
        printList(newHead);

    }


    public static ListNode removeNthNode(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        while (n-- > 0) {
            fast = fast.next;
        }

        if (fast == null) return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
