package neetCode150.LinkedList;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Reorder_List {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        mid = reverse(mid);

        while(mid != null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = mid.next;

            head.next = mid;
            mid.next = tmp1;

            head = tmp1;
            mid = tmp2;
        }
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }

    public void reorderList2(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        mid = reverse(mid);

        while(mid != null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = mid.next;

            head.next = mid;
            mid.next = tmp1;

            head = tmp1;
            mid = tmp2;
        }
    }

    public static void main(String[] args) {
        int[] heads = {1,2,3,4,5};
        ListNode listNode = new ListNode(heads[0]);
        ListNode tempNode = new ListNode(heads[1]);
        ListNode[] n = {tempNode};
        listNode.next = n[0];
        Arrays.stream(heads, 2, heads.length)
                .mapToObj(ListNode::new)
                .forEach(v->{
                    n[0].next = v;
                    n[0] = n[0].next;
                });

        ListNode listNode2 = new ListNode(heads[0]);
        ListNode tempNode2 = new ListNode(heads[heads.length-1]);
        for (int i = heads.length-2; i >= 1; i--){
            ListNode tmp = new ListNode(heads[i]);
            tmp.next = tempNode2;
            tempNode2 = tmp;
        }
        listNode2.next = tempNode2;
        new Reorder_List().reorderList(listNode2);
    }
}
