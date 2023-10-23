package neetCode150.LinkedList;

public class ReorderList {
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public void reorderList(ListNode head) {
        ListNode headNode = head;
        ListNode lastLinkedNode = new ListNode();
        while (head != null) {
            head.next = invokeLastNode(head, lastLinkedNode);
            head = head.next;
            head.next = lastLinkedNode.next;
            head = head.next;
            if (head == null || head.next == null || head.next.next == null) break;;
        }
        head = headNode;
    }
    private ListNode invokeLastNode(ListNode node, ListNode lastLinkedNode) {
        if (node == null) return null;
        else if (node.next == null) return node;
        node = node.next;
        ListNode prev = lastLinkedNode;
        if (node.next!=null) {
            prev.next = new ListNode(node.val);
            lastLinkedNode = lastLinkedNode.next;
        }
        return invokeLastNode(node, lastLinkedNode);
    }

    public static void main(String[] args) {
        int arrays[] = {1,2,3,4,5};
        ListNode listNode = createLinkedNode(arrays);
        new ReorderList().reorderList(listNode);
    }
    public static ListNode createLinkedNode(int [] list){
        if (list.length == 0) return null;
        if (list.length < 2) return new ListNode(list[0]);
        ListNode linkedList = new ListNode(list[0]);
        ListNode listNext = new ListNode(list[1]);
        linkedList.next = listNext;
        for (int i = 2; i < list.length; i++) {
            ListNode temp = new ListNode(list[i]);
            listNext.next = temp;
            listNext = listNext.next;
        }
        return linkedList;
    }
}
