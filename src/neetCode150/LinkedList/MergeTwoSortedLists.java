package neetCode150.LinkedList;

public class MergeTwoSortedLists {
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergeNode = new ListNode();
        ListNode head = mergeNode;
        while (list1 != null || list2 != null) {
            boolean bothNotNull = list1 != null && list2 != null;
            if (list1 == null && list2 != null) {
                mergeNode.next = list2;
                list2 = list2.next;
            }
            if (list1 != null && list2 == null) {
                mergeNode.next = list1;
                list1 = list1.next;
            }
            if (bothNotNull && list1.val >= list2.val) {
                ListNode moveNode = new ListNode(list2.val);
                mergeNode.next = moveNode;
                list2 = list2.next;
            }
            else if (bothNotNull && list1.val < list2.val) {
                ListNode moveNode = new ListNode(list1.val);
                mergeNode.next = moveNode;
                list1 = list1.next;
            }
            mergeNode = mergeNode.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int []list1s = {1, 2, 4};
        int []list2s = {1, 3, 4};
        ListNode list1 = createLinkedNode(list1s);
        ListNode list2 = createLinkedNode(list2s);

        new MergeTwoSortedLists().mergeTwoLists(list1, list2);

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
