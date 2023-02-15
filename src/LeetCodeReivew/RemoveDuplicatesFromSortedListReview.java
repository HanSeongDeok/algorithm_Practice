package LeetCodeReivew;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedListReview {
    static class Node<T>{
        T val;
        Node next;
        Node (T val, Node next){
            this.val = val;
            this.next = next;
        }
    }
    static Node solution(Node head){
        Node temp = head;
        Node checkDuplicates = head;
        while(temp != null){
            while(checkDuplicates!=null && checkDuplicates.next!=null){
                if(checkDuplicates.next.val == temp.val){
                    checkDuplicates.next = checkDuplicates.next.next;
                }
                checkDuplicates = checkDuplicates.next;
            }
            temp = temp.next;
            checkDuplicates = temp;
        }
        return head;
    }

    static Node solution2(Node head){
        Node temp1 = head;
        Node temp2 = head;
        while(temp1!=null){
            while(temp2.next!=null){
                if(temp1.val == temp2.next.val){
                    temp2.next = temp2.next.next;
                } else {
                    temp2 = temp2.next;
                }
            }
            temp1 = temp1.next;
            temp2 = temp1;
        }
        return head;
    }

    static Set solution3(Node head){
        Set setHead = new LinkedHashSet();
        while(head!=null){
            setHead.add(head.val);
            head = head.next;
        }
        return setHead;
    }

    public static void main(String[] args) {
        int nodeList[] = {1,1,2,3,3};
        Node temp = null;
        for(int i=nodeList.length-1; i>=0; i--){
            temp = new Node(nodeList[i], temp);
        }

        Iterator iteratorSet = solution3(temp).iterator();
        String print = "";
        while(iteratorSet.hasNext()){
            String a = String.valueOf(iteratorSet.next());
            print += a+",";
        }
        //print = print.replaceAll(".$","");
        print = print.substring(0,print.length()-1);
        System.out.println("["+print+"]");

        System.out.println("----");
        temp = solution2(temp);
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }


    }
}
