package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ListNode4 {
      int val;
      ListNode4 next;
      ListNode4() {}
      ListNode4(int val) { this.val = val; }
      ListNode4(int val, ListNode4 next) { this.val = val; this.next = next; }
  }
public class AddTwoNumbers {
    public static int solution(ListNode4 l1, ListNode4 l2){
        List<Integer> tempList = new ArrayList<>();
        List<Integer> tempList2 = new ArrayList<>();
        while(l1 != null){
            tempList.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            tempList2.add(l2.val);
            l2 = l2.next;
        }
        Collections.reverse(tempList);
        Collections.reverse(tempList2);
        int [] list1 = tempList.stream().mapToInt(i -> i).toArray();
        int [] list2 = tempList2.stream().mapToInt(i -> i).toArray();
        int listSum = 0;
        int listSum2 = 0;
        int ten=10;
        for(int i=0; i<list1.length;i++){
            if(i>1)ten*=10;
            if(i==0){
                listSum += list1[i];
            }else {
                listSum += list1[i]*ten;
            }
        }
        ten=10;
        for(int i=0; i<list2.length;i++){
            if(i>1)ten*=10;
            if(i==0){
                listSum2 += list2[i];
            }else {
                listSum2 += list2[i]*ten;
            }
        }
        return listSum + listSum2;
    }
    public static void main(String[] args) {
        int []list = {3, 4, 2};
        int []list2 = {4, 6, 5};
        ListNode4 l1 = null;
        ListNode4 l2 = null;
        l1 = makeLinkedList(list, l1);
        l2 = makeLinkedList(list2, l2);
        System.out.println(solution(l1, l2));
    }

    public static ListNode4 makeLinkedList(int[]list, ListNode4 node){
        for(int i=0; i<list.length; i++){
            node = new ListNode4(list[i], node);
        }
        return node;
    }
}
