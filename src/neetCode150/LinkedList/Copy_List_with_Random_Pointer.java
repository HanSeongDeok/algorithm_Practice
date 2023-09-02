package neetCode150.LinkedList;

public class Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        Node node = head;
        Node nextNode;
        while (node != null) {
            nextNode = node.next;
            Node copy = new Node(nextNode.val);
            node.next = copy;
            copy.next = nextNode;
            node = nextNode;
        }

        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        node = head;
        Node copyNext = new Node(0);
        Node temp;
        while (node != null) {
            nextNode = node.next.next;
            temp = node.next;
            copyNext.next = temp;
            copyNext = temp;
            //TODO 두개가 같은지 => 같은 문장이라고 봄
            node.next = nextNode;
            node = node.next;
            node = nextNode;
        }
        return copyNext.next;
    }
    public static void main(String[] args) {
    }

}
