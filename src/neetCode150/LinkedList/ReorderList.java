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

        if(head==null||head.next==null) return;

        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p1.next.next;
            p2 = preMiddle.next;
        }

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

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        /**
         * 방법 1. reverse 방법
         */
       /* ListNode halfNode = slowNode;
        ListNode reverseNode = halfNode.next;
        ListNode prev = null;
        while (reverseNode != null) {
            ListNode temp = reverseNode.next;
            reverseNode.next = prev;
            prev = reverseNode;
            reverseNode = temp;
        }*/

        /**
         * 방법 2. reverse 방법
         */
        ListNode halfNode2 = slowNode;
        ListNode reverseNode2 = halfNode2.next;
        while (reverseNode2 != null) {
            ListNode temp = reverseNode2.next;
            reverseNode2.next = temp.next;
            temp.next = halfNode2.next;
            halfNode2.next = temp;
        }

        ListNode headNode = head;
        ListNode reversedNode = halfNode2.next;
        while (reversedNode.next != null){
            halfNode2.next = halfNode2.next.next;
            reversedNode.next = headNode.next;
            headNode.next = reversedNode;
        }

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
        int arrays[] = {1,2,3,4,5,6};
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
