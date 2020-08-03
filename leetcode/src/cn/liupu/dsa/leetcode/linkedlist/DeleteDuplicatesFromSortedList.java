package cn.liupu.dsa.leetcode.linkedlist;

/**
 * @description:
 * @author: liupu1
 * @create: 2020/8/2 2:27 PM
 * <p>
 * 从有序链表中删除重复元素
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 **/
public class DeleteDuplicatesFromSortedList {

    public static void main(String[] args) {

        String[] arr = new String[]{"5", "4", "4", "3", "2", "2", "1", "1", "1"};
        ListNode list = ListNode.of(arr);
        ListNode.printList(list);

//        ListNode newList = deleteDuplicates(list);
        ListNode newList = deleteDuplicatesRecursive(list);
        ListNode.printList(newList);
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != null && next != null) {
            if (cur.val.equals(next.val)) {
                cur.next = next.next;
                next = cur.next;
            } else {
                cur = next;
                next = next.next;
            }
        }

        return head;
    }

    public static ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicatesRecursive(head.next);

        return head.val.equals(head.next.val) ? head.next : head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode q = head;
        while (q != null && q.next != null) {
            if (q.val == q.next.val) {
                q.next = q.next.next;
            } else {
                q = q.next;
            }
        }
        return head;
    }


}
