package LeetCodeReivew;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LinkedListReview<T>{
    NodeReview nodeReview;
    static class NodeReview<T>{
        T data;
        NodeReview next;
        NodeReview(T data, NodeReview next){
            this.data = data;
            this.next = next;
        }
    }

    void addLinkedList(T data, NodeReview next){
        NodeReview node = new NodeReview(data, next);
        NodeReview temp = nodeReview;
        if(nodeReview == null) nodeReview = node;
        else{
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    public static boolean solution(NodeReview head){
        /**
         * 방법 1
         */
        /*while(head != null){
            if(head.data.equals(10000)){
                return true;
            }
            head.data = 10000;
            head = head.next;
        }*/
        /**
         * 방법 2
         */
      /*  Set set = new HashSet();
        while (head != null){
            if(set.contains(head.data)){
                return true;
            }
            set.add(head.data);
            head = head.next;
        }*/
        /**
         * 방법 3
         */
        NodeReview slowNode = head;
        NodeReview fastNode = head;
        while(fastNode != null && fastNode.next != null){
            if(slowNode.next.equals(fastNode.next.next)){
                return true;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return false;
    }
    public static void main(String[] args) {
        LinkedListReview test = new LinkedListReview();
        int [] linkedList = {10, 20, 30, 40, 50};

        /**
         * linkedList의 값들을 Node에 추가하는 방법 1 (addLast 함수를 따로 만들기)
         */
        NodeReview temp = test.nodeReview;
        for(int i =0; i < linkedList.length; i++){
            test.addLinkedList(linkedList[i], temp);
        }

        /**
         * linkedList의 값들을 Node에 추가하는 방법 2 (addLast 함수없이 바로 구현)
         */
        NodeReview temp2 = null;
        NodeReview nodeOfTemp2 = null;
        for(int i=0; i<linkedList.length; i++){
            if(temp2==null){
                temp2 = new NodeReview(linkedList[i], temp2);
                nodeOfTemp2 = temp2;
            } else{
                NodeReview tempOfTemp2 = new NodeReview(linkedList[i], null);
                nodeOfTemp2.next = tempOfTemp2;
                nodeOfTemp2 = nodeOfTemp2.next;
            }
        }

        /**
         * linkedList의 값들을 Node에 추가하는 방법 3 (addFirst 객체 안의 객체를 바로 만들기)
         */
        NodeReview temp3 = null;
        for(int i=linkedList.length-1; i>=0; i--){
            temp3 = new NodeReview(linkedList[i], temp3);
        }

        temp = test.nodeReview;
       // temp.next.next.next.next = temp.next;
        System.out.println(solution(temp));
    }
}
