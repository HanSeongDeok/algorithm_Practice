package LeetCode;

import java.util.HashMap;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class LinkedListCycle2 {
    public static ListNode detectCycle(ListNode head){
        HashMap map = new HashMap();
        int count = 0;
        while(head != null) {
            if(map.containsKey(head)){
                System.out.println("tail connects to node index "+map.get(head));
                return head;
            }
            map.put(head, count++);
            head = head.next;
        }
        System.out.println("no cycle");
        return head;
    }
    public static void main(String[] args) {
        int [] list = {1, 2};
        ListNode temp = null;
        ListNode n = null;
        for(int i=0; i<list.length; i++){
            if(temp == null){
                temp = new ListNode(list[i]);
                n = temp;
            } else {
                temp.next = new ListNode(list[i]);
                temp = temp.next;
            }
        }
        temp = null;
        ListNode n2 = null;
        for(int i=list.length-1; i>=0 ; i--){
            temp = new ListNode(list[i]);
            temp.next = n2;
            n2 = temp;
        }
        //n2.next.next = n2;
        detectCycle(n2);
    }
}
