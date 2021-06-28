package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/27 11:30 下午
 **/
public class NC40_SumOfTwoLinkedList {

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        NC40_SumOfTwoLinkedList demo = new NC40_SumOfTwoLinkedList();
        ListNode node = demo.reverseNode(node1);
        System.out.println();
    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        ListNode node1 = reverseNode(head1);
        ListNode node2 = reverseNode(head2);

        int carry = 0;

        ListNode result = null;
        while (node1 != null || node2 != null || carry > 0) {
            int num1 = node1 != null ? node1.val : 0;
            int num2 = node2 != null ? node2.val : 0;
            int sum = num1 + num2 + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(val);
            node.next = result;
            result = node;
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }

        return result;
    }

    private ListNode reverseNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

}
