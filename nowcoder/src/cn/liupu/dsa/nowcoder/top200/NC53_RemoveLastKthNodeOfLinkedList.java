package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/26 3:13 下午
 **/
public class NC53_RemoveLastKthNodeOfLinkedList {

    public static void main(String[] args) {

        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode pHead = new ListNode(1, node2);

        NC53_RemoveLastKthNodeOfLinkedList demo = new NC53_RemoveLastKthNodeOfLinkedList();

        ListNode node = demo.removeNthFromEnd(pHead, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }

        if (pre == slow) {
            return head.next;
        }

        pre.next = slow.next;
        return head;
    }
}
