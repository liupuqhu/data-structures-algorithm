package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/20 11:42 下午
 **/
public class NC33_ConcatSortedLinkedList {

    public static void main(String[] args) {

        NC33_ConcatSortedLinkedList demo = new NC33_ConcatSortedLinkedList();

        ListNode node3 = new ListNode(3);
        ListNode node1 = new ListNode(1, node3);

        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node2 = new ListNode(2, node4);

        ListNode node = demo.mergeTwoLists(node1, node2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return head.next;
    }

}
