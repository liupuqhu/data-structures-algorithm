package cn.liupu.dsa.nowcoder.top200;

import java.util.Stack;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/27 10:49 下午
 **/
public class NC66_FindFirstCommonNode {

    public static void main(String[] args) {

        ListNode node7 = new ListNode(7, null);
        ListNode node6 = new ListNode(6, node7);

        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);

        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        NC66_FindFirstCommonNode demo = new NC66_FindFirstCommonNode();
        ListNode node = demo.FindFirstCommonNode4(node1, node4);
        System.out.println(node.val);
    }

    public ListNode FindFirstCommonNode4(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode ta = pHead1, tb = pHead2;
        while (ta != tb) {
            ta = ta != null ? ta.next : pHead2;
            tb = tb != null ? tb.next : pHead1;
        }
        return ta;
    }

    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;

        int count = 0;
        while (count <= 2 && (node1 != null || node2 != null)) {
            if (node1 == node2) {
                return node1;
            }
            if (node1 == null) {
                node1 = pHead2;
                count++;
            }
            if (node2 == null) {
                node2 = pHead1;
                count++;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return null;
    }

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        int len1 = lengthOfLinkedList(pHead1);
        int len2 = lengthOfLinkedList(pHead2);

        if (len1 > len2) {
            return FindFirstCommonNode2(pHead1, len1, pHead2, len2);
        } else {
            return FindFirstCommonNode2(pHead2, len2, pHead1, len1);
        }
    }

    private ListNode FindFirstCommonNode2(ListNode node1, int len1, ListNode node2, int len2) {
        int n = len1 - len2;
        while (n > 0) {
            node1 = node1.next;
            n--;
        }

        boolean flag = false;
        while (node1 != null && node2 != null) {
            if (node1 == node2) {
                flag = true;
                break;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return flag ? node1 : null;
    }

    private int lengthOfLinkedList(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stack1 = pushLinkedListIntoStack(pHead1);
        Stack<ListNode> stack2 = pushLinkedListIntoStack(pHead2);

        ListNode node = null;
        while (stack1.peek() == stack2.peek() && !stack1.isEmpty() && !stack2.isEmpty()) {
            node = stack1.pop();
            stack2.pop();
        }

        return node;
    }

    private Stack<ListNode> pushLinkedListIntoStack(ListNode node) {
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        return stack;
    }

}
