package neetCode150.LinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LRUCachePractice2 {
    static class LRUCache {
        Map<Integer, TempNode> map = null;
        int capacity = 0;
        LinkedApi linkedApi;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
            linkedApi = new LinkedApi();
        }
        public int get(int key) {
            TempNode node = map.get(key);
            if (node == null) {
                return -1;
            }
            map.remove(key);
            linkedApi.moveToHead(node);
            return node.value;
        }
        public void put(int key, int value) {
            TempNode node = map.get(key);
            if (node != null) {
                linkedApi.moveToHead(node);
                node.value = value;
            }
            if (node == null && map.size() == capacity){
                TempNode addNode = new TempNode(key, value);
                map.remove(linkedApi.getTail().key);
                linkedApi.addToHead(addNode);
                linkedApi.removeTail();
                map.put(key, addNode);
            }
            if (node == null && map.size() != capacity) {
                TempNode addNode = new TempNode(key, value);
                linkedApi.addToHead(addNode);
                map.put(key, addNode);
            }
        }
    }
    static class LinkedApi {
        TempNode head;
        TempNode tail;
        public LinkedApi(){
            head = new TempNode(0,0);
            tail = new TempNode(0,0);
            head.next = tail;
            tail.prev = head;
        }
        public void moveToHead(TempNode node) {
           node.prev.next = node.next;
           node.next.prev = node.prev;
           addToHead(node);
        }
        public void addToHead(TempNode node) {
            TempNode moveNode = head.next;
            head.next = node;
            node.next = moveNode;
            node.prev = head;
            moveNode.prev = node;
        }
        public void removeTail(){
            TempNode moveNode = tail.prev.prev;
            moveNode.next = tail;
            tail.prev = moveNode;
        }
        public TempNode getTail(){
            return tail;
        }
    }
    static class TempNode {
        int key;
        int value;
        TempNode prev;
        TempNode next;
        public TempNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public static void main(String[] args) {

    }
}
