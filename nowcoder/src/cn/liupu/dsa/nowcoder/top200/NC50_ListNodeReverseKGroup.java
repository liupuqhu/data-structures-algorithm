package cn.liupu.dsa.nowcoder.top200;

import java.util.Stack;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/22 4:14 下午
 **/
public class NC50_ListNodeReverseKGroup {


    public static void main(String[] args) {

        NC50_ListNodeReverseKGroup demo = new NC50_ListNodeReverseKGroup();
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        ListNode node = head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

        System.out.println("====================");

        node = demo.reverseKGroup(head, 3);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();

        ListNode ret = new ListNode(0);
        ListNode node = ret;

        while (true) {
            int count = 0;
            ListNode tmp = head;

            while (tmp != null && count < k) {
                stack.push(tmp);
                tmp = tmp.next;
                count++;
            }

            if (count != k) {
                node.next = head;
                break;
            }

            while (!stack.isEmpty()) {
                node.next = stack.pop();
                node = node.next;
            }

            node.next = tmp;
            head = tmp;

        }

        return ret.next;
    }
}
