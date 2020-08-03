package cn.liupu.dsa.leetcode.linkedlist;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/2 3:05 PM
 * <p>
 * 交换链表中相邻节点
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 **/
public class SwapNodesInPairs {

    public static void main(String[] args) {

        ListNode head = ListNode.of(new String[]{"5", "4", "3", "2", "1"});

        ListNode newHead = swapPairs2(head);
        ListNode.printList(newHead);

    }

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;

        ListNode next = second.next;
        second.next = first;
        first.next = next;
        head = second;
        head.next.next = swapPairs(next);
        return head;
    }

    private static ListNode swapPairs2(ListNode head) {
        ListNode node = new ListNode("");
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next;
            ListNode l2 = pre.next.next;

            ListNode next = l2.next;
            l2.next = l1;
            l1.next = next;

            pre.next = l2;
            pre = l1;
        }
        return node.next;
    }
}
