package neetCode150.LinkedList;

import java.util.HashMap;
import java.util.Map;

class TempRandomNode {
    int val;
    TempRandomNode next;
    TempRandomNode random;
    public TempRandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyRandomList {
    public TempRandomNode copyRandomList(TempRandomNode head){
        Map<TempRandomNode, TempRandomNode> map = new HashMap<>();
        TempRandomNode node = head;
        deeplyCopyNode(head, map);
        deeplyCopyLinkedNode(node, map);
        return map.get(head);
    }
    private TempRandomNode deeplyCopyNode(TempRandomNode node, Map<TempRandomNode, TempRandomNode> map){
        if (node == null) return null;
        TempRandomNode copyNode = node;
        map.put(copyNode, new TempRandomNode(node.val));
        copyNode = copyNode.next;
        return deeplyCopyNode(copyNode, map);
    }
    private TempRandomNode deeplyCopyLinkedNode(TempRandomNode node, Map<TempRandomNode, TempRandomNode> map){
        if (node == null) return null;
        TempRandomNode linkedNode = node;
        map.get(linkedNode).next = map.get(linkedNode.next);
        map.get(linkedNode).random = map.get(linkedNode.random);
        linkedNode = linkedNode.next;
        return deeplyCopyLinkedNode(linkedNode, map);
    }
    public static void main(String[] args) {
        int nextValues[] = {7, 13, 11, 10, 1};
        int randomValues[] = {-1, 0, 4, 2, 0};
        TempRandomNode case1 = new TempRandomNode(nextValues[0]);
        TempRandomNode temp = new TempRandomNode(nextValues[1]);
        case1.next = temp;
        for (int i = 2; i < nextValues.length; i++) {
            TempRandomNode tempNextNode = new TempRandomNode(nextValues[i]);
            temp.next = tempNextNode;
            temp = temp.next;
        }

        for (int i = 0; i < randomValues.length; i++) {
            new CopyRandomList().createRandomNode(i, case1);
        }
    }
    public TempRandomNode createRandomNode(int index, TempRandomNode case1){

        return null;
    }
}
