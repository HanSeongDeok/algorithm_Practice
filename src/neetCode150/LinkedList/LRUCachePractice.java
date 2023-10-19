package neetCode150.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCachePractice {
    int capacity = 0;
    Map<Integer, NodeTemp> map = null;
    CustomLinkedNode customLinkedNode = null;
    public LRUCachePractice(int capacity) {
        this.capacity = capacity;
        this.customLinkedNode = new CustomLinkedNode();
        this.map = new HashMap<>();
    }
    public int get(int key) {
        NodeTemp node = map.get(key);
        if (node == null) return -1;
        else {
            customLinkedNode.moveToHead(node);
            return node.value;
        }
    }
    public void put(int key, int value) {
        if (map.get(key) != null) {
            map.get(key).value = value;
            customLinkedNode.moveToHead(map.get(key));
        }
        if (map.get(key) == null) {
            map.put(key, new NodeTemp(key, value));
            customLinkedNode.addToHead(map.get(key));
        }
        if (map.size() == capacity) {
            map.remove(customLinkedNode.getTail().key);
            customLinkedNode.removeTail();
        }
    }
}
class CustomLinkedNode {
    NodeTemp head;
    NodeTemp tail;
    CustomLinkedNode(){
        head = new NodeTemp(0, 0);
        tail = new NodeTemp(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    public void moveToHead(NodeTemp nodeTemp){
        nodeTemp.prev.next = nodeTemp.next;
        nodeTemp.next.prev = nodeTemp.prev;
        addToHead(nodeTemp);
    }
    public void addToHead(NodeTemp nodeTemp) {
        NodeTemp temp = head.next;
        head.next = nodeTemp;
        nodeTemp.next = temp;
        nodeTemp.prev = head;
        temp.prev = nodeTemp;
    }
    public void removeTail(){
        NodeTemp temp = tail.prev.prev;
        temp.next = tail;
        tail.prev = temp;
    }
    public NodeTemp getTail(){
        return this.tail;
    }
    public NodeTemp getHead(){
        return this.head;
    }
}

class NodeTemp {
    int key;
    int value;
    NodeTemp next;
    NodeTemp prev;
    public NodeTemp(int key, int value){
        this.key = key;
        this.value = value;
    }
}
