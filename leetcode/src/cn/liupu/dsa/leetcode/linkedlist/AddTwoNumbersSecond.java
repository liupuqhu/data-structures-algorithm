package cn.liupu.dsa.leetcode.linkedlist;

import java.util.Stack;

import static cn.liupu.dsa.leetcode.linkedlist.ListNode.printList;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/2 3:59 PM
 **/
public class AddTwoNumbersSecond {

    public static void main(String[] args) {

        ListNode l1 = ListNode.of(new Integer[]{3, 4, 2, 7});
        ListNode l2 = ListNode.of(new Integer[]{4, 6, 5});

        printList(l1);
        printList(l2);
        ListNode head = addTwoNumbers2(l1, l2);
        printList(head);


    }

    public static ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {

        Stack<Integer> num1 = list2Stack(l1);
        Stack<Integer> num2 = list2Stack(l2);

        ListNode<Integer> head = null;

        int tmp = 0;
        int carry = 0;

        while (!num1.isEmpty() || !num2.isEmpty() || carry > 0) {
            if (!num1.isEmpty()) {
                tmp += num1.pop();
            }
            if (!num2.isEmpty()) {
                tmp += num2.pop();
            }
            if (carry > 0) {
                tmp += carry;
            }
            carry = tmp / 10;
            tmp = tmp % 10;
            ListNode<Integer> node = new ListNode<>(tmp);
            node.next = head;
            head = node;
            tmp = 0;
        }

        return head;
    }

    public static ListNode addTwoNumbers2(ListNode<Integer> l1, ListNode<Integer> l2) {

        Stack<Integer> num1 = list2Stack(l1);
        Stack<Integer> num2 = list2Stack(l2);

        ListNode<Integer> node = new ListNode<>(-1);

        int carry = 0;

        while (!num1.isEmpty() || !num2.isEmpty() || carry != 0) {
            int x = num1.isEmpty() ? 0 : num1.pop();
            int y = num2.isEmpty() ? 0 : num2.pop();
            int sum = x + y + carry;
            ListNode<Integer> head = new ListNode<>(sum % 10);
            head.next = node.next;
            node.next = head;
            carry = sum / 10;
        }

        return node.next;
    }

    private static Stack<Integer> list2Stack(ListNode<Integer> node) {
        Stack<Integer> num = new Stack<>();

        while (node != null) {
            num.push(node.val);
            node = node.next;
        }
        return num;
    }
}
