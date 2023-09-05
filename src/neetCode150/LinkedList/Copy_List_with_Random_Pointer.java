package neetCode150.LinkedList;

public class Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        Node node = head;
        Node nextNode;
        while (node != null) {
            nextNode = node.next;

            Node copy = new Node(node.val);
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
        }
        return copyNext.next;
    }
    public static void main(String[] args) {
        int arrays[] = {7,13,11,10,1};
        int randomArrays[] = {-1,0,4,2,0};

        Node node = new Node(arrays[0]);
        node.random = null;

        Node tempNode = new Node(arrays[1]);
        tempNode.random = new Node(randomArrays[1]);

        node.next = tempNode;
        for (int i=2; i< arrays.length; i++) {
            Node temp = new Node(arrays[i]);
            temp.random = new Node(randomArrays[i]);

            tempNode.next = temp;
            tempNode = tempNode.next;
        }
        new Copy_List_with_Random_Pointer().copyRandomList(node);
    }
}
