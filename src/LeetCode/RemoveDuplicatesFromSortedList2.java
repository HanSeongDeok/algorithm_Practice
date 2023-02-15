package LeetCode;

class ListNode2 {
      int val;
      ListNode2 next;
      ListNode2() {}
      ListNode2(int val) { this.val = val; }
      ListNode2(int val, ListNode2 next) { this.val = val; this.next = next;}
  }
public class RemoveDuplicatesFromSortedList2 {
    public static ListNode2 deleteDuplicates(ListNode2 head){
        int count = 0;
        ListNode2 head2 = new ListNode2(0, head);
        ListNode2 preHead2 = head2;
        ListNode2 temp = head;
        while(temp != null){
            while(temp.next != null && temp.next.val == head.val){
                temp = temp.next;
                count++;
            }
            if(count>0) {
                temp = temp.next;
                head.next = temp;
                preHead2.next = temp;
                count = 0;
            } else{
                preHead2 = preHead2.next;
                temp = temp.next;
            }
            head = head.next;
        }

        return null;
    }
    public static void main(String[] args) {
        int [] list = {5,4,4,3,3,2,1};
        ListNode2 head = null;
        for(int i=0; i< list.length; i++){
            head = new ListNode2(list[i], head);
        }
        deleteDuplicates(head);
    }
}
