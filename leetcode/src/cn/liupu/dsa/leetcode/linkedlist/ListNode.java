package cn.liupu.dsa.leetcode.linkedlist;

/**
 * Definition for singly-linked list.
 * <p>
 * 链表相关的10到经典算法题
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E9%93%BE%E8%A1%A8.md
 * <p>
 * 1. 找出两个链表的交点
 * 2. 链表反转
 * 3. 归并两个有序的链表
 * 4. 从有序链表中删除重复节点
 * 5. 删除链表的倒数第 n 个节点
 * 6. 交换链表中的相邻结点
 * 7. 链表求和
 * 8. 回文链表
 * 9. 分隔链表
 * 10. 链表元素按奇偶聚集
 */
public class ListNode<T> {

    T val;
    ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(T val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static <T> ListNode<T> of(T[] arr) {
        ListNode<T> head = null;
        for (T val : arr) {
            ListNode node = new ListNode(val);
            node.next = head;
            head = node;
        }
        return head;
    }

}