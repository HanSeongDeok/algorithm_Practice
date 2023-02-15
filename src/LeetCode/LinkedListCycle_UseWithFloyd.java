package LeetCode;

class Node<T>{
    T data;
    Node next;
    Node(T data, Node next){
        this.data = data;
        this.next = next;
    }
}
public class LinkedListCycle_UseWithFloyd {
    public boolean detectCycle(Node head){
        Node fastNode = head;
        Node slowNode = head;
        while (fastNode.next != null && fastNode != null) {
            if(fastNode.next.next==slowNode.next){
                return true;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return false;
    }
    public static void main(String[] args) {
        LinkedListCycle_UseWithFloyd test = new LinkedListCycle_UseWithFloyd();
        int []keys = {1,2,3,4,5};
        //addFirst
        Node head = null;
        for (int i = keys.length-1; i>=0; i--){
            head = new Node(keys[i],head);
        }

        head.next.next.next = head.next.next;

        if(test.detectCycle(head)) System.out.println("CYCLE_TRUE");
        else System.out.println("CYCLE_FALSE");
    }
}
