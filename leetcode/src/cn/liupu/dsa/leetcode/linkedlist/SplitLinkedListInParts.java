package cn.liupu.dsa.leetcode.linkedlist;

import static cn.liupu.dsa.leetcode.linkedlist.ListNode.printList;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/3 8:16 PM
 * <p>
 * 链表尽可能等比例切分
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
 **/
public class SplitLinkedListInParts {

    public static void main(String[] args) {

        ListNode head = ListNode.of(new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});

        printList(head);

        ListNode[] listNodes = splitListInParts(head, 12);

        for (ListNode listNode : listNodes) {
            printList(listNode);
        }

        System.out.println("end");
    }

    public static ListNode[] splitListInParts(ListNode head, int k) {
        int N = 0;
        ListNode cur = head;
        while (cur != null) {
            N++;
            cur = cur.next;
        }

        int mod = N % k;
        int size = N / k;

        ListNode[] result = new ListNode[k];
        cur = head;

        for (int i = 0; cur != null && i < k; i++) {
            result[i] = cur;
            int curSize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }

        return result;
    }
}
