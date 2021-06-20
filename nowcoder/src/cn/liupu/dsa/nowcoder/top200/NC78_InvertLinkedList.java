package cn.liupu.dsa.nowcoder.top200;

import java.security.Principal;

/**
 * @description: 反转链表
 * @author: liupu1
 * @create: 2021/6/5 3:26 下午
 * <p>
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=117&&tqId=37777&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 **/
public class NC78_InvertLinkedList {

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        printLinkedList(head);
        printLinkedList(reverseList(head));

    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static void printLinkedList(ListNode node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
