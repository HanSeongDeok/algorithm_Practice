package neetCode150.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Remove_Nth_Node_From_End_of_List {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            return null;
        }
    }

    public static void main(String[] args) {
        int [] numbers = {1,2,3,4,5};
        ListNode listNode = new ListNode(numbers[0]);
        ListNode temp = new ListNode(numbers[1]);
        listNode.next = temp;
        for (int i = 2; i < numbers.length; i++) {
            ListNode temp2 = new ListNode(numbers[i]);
            temp.next = temp2;
            temp = temp.next;
        }

        ListNode listNode2 = new ListNode(numbers[0]);
        ListNode temp2 = new ListNode(numbers[numbers.length-1]);
        for (int i = numbers.length-2; i>0; i--) {
            ListNode temp3 = new ListNode(numbers[i]);
            temp3.next = temp2;
            temp2 = temp3;
        }
        listNode2.next = temp2;


    }
}
