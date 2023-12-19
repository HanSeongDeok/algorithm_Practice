package neetCode150.LinkedList;

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //ListNode reverseL1Node = reverseLinkedNode(l1);
        //ListNode reverseL2Node = reverseLinkedNode2(l2, null);
        int upCheck = 0;
        int firstAdd = l1.val + l2.val;
        ListNode addNode = new ListNode();
        if (firstAdd / 10 > 0) {
            addNode.val = firstAdd % 10;
            upCheck = 1;
        } else addNode.val = firstAdd;
        l1 = l1.next;
        l2 = l2.next;

        ListNode head = addNode;
        while (l1 != null || l2 != null || upCheck == 1) {
            int add = 0;
            if (l1 == null && l2 !=null) add = l2.val + upCheck;
            if (l1 != null && l2 ==null) add = l1.val + upCheck;
            if (l1 == null && l2 ==null) add = upCheck;
            if (l1 != null && l2 !=null) add = l1.val + l2.val + upCheck;
            ListNode temp = null;
            if (add / 10 > 0){
                int up = add % 10;
                temp = new ListNode(up);
                upCheck = 1;
            }
            if (add / 10 == 0){
                temp = new ListNode(add);
                upCheck = 0;
            }
            addNode.next = temp;
            addNode = addNode.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return head;
    }
    private ListNode reverseLinkedNode(ListNode node){
        ListNode head = node;
        ListNode reverseNode = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = reverseNode;
            reverseNode = head;
            head = nextNode;
        }
        return reverseNode;
    }

    private ListNode reverseLinkedNode2(ListNode node, ListNode temp){
        if (node == null) return temp;
        ListNode moveNode = node.next;
        ListNode prevNode = node;
        prevNode.next = temp;
        return reverseLinkedNode2(moveNode, prevNode);
    }

    public static void main(String[] args) {
        int test[]  = {5, 5, 5, 5};
        ListNode temp = new ListNode(test[0]);
        ListNode nextTemp = new ListNode(test[1]);
        temp.next = nextTemp;
        for (int i = 2; i < test.length; i++) {
            ListNode temp2 = new ListNode(test[i]);
            nextTemp.next = temp2;
            nextTemp = nextTemp.next;
        }

        ListNode temp2 = new ListNode(test[test.length-1]);
        ListNode prevTemp2 = new ListNode(test[test.length-2]);
        prevTemp2.next = temp2;
        for (int i = 1; i >= 0; i--) {
            ListNode head = new ListNode(test[i]);
            head.next = prevTemp2;
            prevTemp2 = head;
            if (i == 0) temp2 = prevTemp2;
        }

        new AddTwoNumber().addTwoNumbers(temp, temp2);
    }
}
