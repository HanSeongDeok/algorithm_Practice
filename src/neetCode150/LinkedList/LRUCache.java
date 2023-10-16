package neetCode150.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    LinkedNodeList list;
    Map<Integer, NodeTmp> map;
    Integer cap;
    public LRUCache(int capacity) {
        list = new LinkedNodeList();
        map = new HashMap(capacity);
        cap = capacity;
    }

    public int get(int key) {
        NodeTmp node = map.get(key);
        if(node == null){
            return -1;
        }
        list.moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        NodeTmp node = map.get(key);
        if(node != null){
            list.moveToHead(node);
            node.val = value;
        }else{
            NodeTmp newNode = new NodeTmp(key, value);
            if(map.size() == cap){
                NodeTmp tail = list.getTail();
                map.remove(tail.key);
                list.removeTail();
            }
            map.put(key, newNode);
            list.addToHead(newNode);
        }
    }
    public static void main(String[] args) {
        LRUCache test = new LRUCache(2);
        test.put(1,1);
        test.put(2,2);
        test.get(1);
        test.put(3,3);
    }
}

class LinkedNodeList{
    NodeTmp dummyHead;
    NodeTmp dummyTail;

    LinkedNodeList(){
        dummyHead = new NodeTmp(0,0);
        dummyTail = new NodeTmp(0,0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    void moveToHead(NodeTmp node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }

    void addToHead(NodeTmp node){
        NodeTmp tmp = dummyHead.next ;
        dummyHead.next = node;
        node.next = tmp;
        //node.prev = dummyHead;
        tmp.prev = node;
    }

    void removeTail(){
        NodeTmp newTail = dummyTail.prev.prev;
        newTail.next = dummyTail;
        dummyTail.prev = newTail;
    }

    NodeTmp getTail(){
        return dummyTail.prev;
    }

}

class NodeTmp{
    int key;
    int val;
    NodeTmp next;
    NodeTmp prev;
    NodeTmp(int key, int value){
        this.key = key;
        this.val =value;
    }
}
