package LeetCode;

// Default class
/*class ListNode4 {
    int val;
    ListNode4 next;
    ListNode4() {}
    ListNode4(int val) { this.val = val; }
    ListNode4(int val, ListNode4 next) { this.val = val; this.next = next; }
}*/
public class ReturnNodeAddTwoNumbers {
    public static ListNode4 solution(ListNode4 l1, ListNode4 l2){
        ListNode4 solutionNode = new ListNode4(0, null);
        ListNode4 temp = solutionNode;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            if (l1 == null) l1 = new ListNode4(0);
            if (l2 == null) l2 = new ListNode4(0);
            if(l1.val + l2.val>=10){
                temp.next = new ListNode4((l1.val+l2.val+carry)%10);
                carry=1;
            }else {
                if(l1.val + l2.val+ carry >= 10){
                    temp.next = new ListNode4((l1.val + l2.val+ carry)%10);
                    carry=1;
                }else{
                    temp.next = new ListNode4(l1.val + l2.val+ carry);
                    carry=0;
                }
            }
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return solutionNode;
    }
    public static void main(String[] args) {
        int l1[] = {9, 9, 9, 9, 9, 9, 9};
        int l2[] = {9, 9, 9, 9};

        ListNode4 head1 = createHeadNode(l1);
        ListNode4 head2 = createHeadNode(l2);
        solution(head1, head2);
    }

    /**
     * 헤드 노드를 만드는 메소드
     * @param settingList
     * @return head
     */
    public static ListNode4 createHeadNode(int[] settingList){
        ListNode4 temp = null;
        ListNode4 head = null;
        for(int i=0; i< settingList.length; i++){
            if(i == 0){
                temp = new ListNode4(settingList[i]);
                head = temp;
            } else {
                temp.next = new ListNode4(settingList[i]);
                temp = temp.next;
            }
        }
        return head;
    }
}
