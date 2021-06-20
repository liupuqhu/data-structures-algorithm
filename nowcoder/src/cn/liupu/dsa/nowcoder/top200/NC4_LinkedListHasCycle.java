package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/20 4:49 下午
 **/
public class NC4_LinkedListHasCycle {

    public static void main(String[] args) {

        ListNode node4 = new ListNode(4,null);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);

        ListNode head = new ListNode(1,node2);
        node4.next = node2;

        NC4_LinkedListHasCycle demo = new NC4_LinkedListHasCycle();
//        ListNode node = head;
//        while (node != null){
//            System.out.println(node.val);
//            node = node.next;
//        }

        System.out.println(demo.hasCycle(head));

    }


    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast.next == slow){
                return true;
            }
        }
        return false;
    }


}
