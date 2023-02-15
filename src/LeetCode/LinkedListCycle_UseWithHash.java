package LeetCode;

import java.util.HashSet;
import java.util.Set;

class Node2 <T> {
    T data;
    Node2 next;
    Node2(T data, Node2 next){
        this.data = data;
        this.next = next;
    }
}
public class LinkedListCycle_UseWithHash {
    public static boolean solution(Node2 head){
        Set set = new HashSet();
        Node2 node = head;
        while (node != null){
            if(set.contains(node)){
                return true;
            }
            set.add(node);
            node = node.next;
        }
        return false;
    }
    public static void main(String[] args) {
        int [] keys = {1,2,3,4,5};
        Node2 head = null;
        Node2 node2 = new Node2(keys[0],null);
        for(int i=0; i<keys.length; i++){
            if(i==0){
                head = node2;
            } else{
                node2.next = new Node2(keys[i],null);
                node2 = node2.next;
            }
        }
        head.next.next.next.next = head.next;
        if(solution(head)){
            System.out.println("CYCLE_TURE");
        } else {
            System.out.println("CYCLE_FALSE");
        }
    }
}
