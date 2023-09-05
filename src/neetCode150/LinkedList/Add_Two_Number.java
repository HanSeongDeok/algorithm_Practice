package neetCode150.LinkedList;

public class Add_Two_Number {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode tempNode = listNode;
        int carryValue = 0;
        while (l1 != null || l2 != null || carryValue > 0){
            if (l1 == null) l1 = new ListNode(0);
            if (l2 == null) l2 = new ListNode(0);
            if (l1.val + l2.val >= 10) {
                tempNode.next = new ListNode((l1.val + l2.val + carryValue) % 10);
                tempNode = tempNode.next;
                carryValue = 1;
            }
            if (l1.val + l2.val < 10 && l1.val + l2.val + carryValue >= 10) {
                tempNode.next = new ListNode((l1.val + l2.val + carryValue) % 10);
                tempNode = tempNode.next;
                carryValue = 1;
            }
            if (l1.val + l2.val < 10 && l1.val + l2.val + carryValue < 10) {
                tempNode.next = new ListNode(l1.val + l2.val + carryValue);
                tempNode = tempNode.next;
                carryValue = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1Temp = l1;
        l1Temp.next = new ListNode(4);
        l1Temp = l1Temp.next;
        l1Temp.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode l2Temp = l2;
        l2Temp.next = new ListNode(6);
        l2Temp = l2Temp.next;
        l2Temp.next = new ListNode(4);

        new Add_Two_Number().addTwoNumbers(l1, l2);
    }
}
