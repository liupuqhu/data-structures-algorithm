package cn.liupu.dsa.nowcoder.top200;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/26 2:25 下午
 **/
public class NC3_EntryNodeOfLoop {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode pHead = new ListNode(1, node2);
        node5.next = node3;

        NC3_EntryNodeOfLoop demo = new NC3_EntryNodeOfLoop();
//        System.out.println(demo.EntryNodeOfLoop(pHead).val);
        System.out.println(demo.EntryNodeOfLoop2(pHead).val);

    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode node = pHead;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }
        return null;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead.next;

        boolean flag = false;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                flag = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (!flag) {
            return null;
        }

        ListNode node = pHead;
        slow = slow.next;
        while (node != slow) {
            node = node.next;
            slow = slow.next;
        }

        return node;
    }
}
