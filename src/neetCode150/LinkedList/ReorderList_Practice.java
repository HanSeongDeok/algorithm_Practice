package neetCode150.LinkedList;

public class ReorderList_Practice {
      class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val;}
      ListNode(int val, ListNode next) { this.val = val; this.next = next;}
  }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode half = slow;
        ListNode reverseNode = half.next;
        while (reverseNode.next != null) {
            ListNode temp = reverseNode.next;
            reverseNode.next = temp.next;
            temp.next = half.next;
            half.next = temp;
        }

        ListNode headNode = head;
        ListNode reversedNode = half.next;
        while (headNode.next != null && headNode.next.next != null){
            half.next = reversedNode.next;
            reversedNode.next = headNode.next;
            headNode.next = reversedNode;
            reversedNode = half.next;
            headNode = headNode.next.next;
        }
    }
}
