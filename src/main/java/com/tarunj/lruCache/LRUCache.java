package com.tarunj.lruCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K, V> {

    private final int capacity;
    private final Node<K, V> head;
    private final Node<K, V> tail;
    private final Map<K, Node<K, V>> nodeMap;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.right = tail;
        tail.left = head;
        nodeMap = new ConcurrentHashMap<>(capacity);
    }

    public synchronized void put(K key, V value) {

        Node<K, V> node = nodeMap.get(key);

        if(node == null) {
            node = new Node<K, V>(key, value);
            nodeMap.put(key, node);
            addToHead(node);
            if(nodeMap.size() > capacity) {
                K keyRemoved = removeTail().key;
                nodeMap.remove(keyRemoved);
            }
        }
        else {
            node.value = value;
            moveToHead(node);
        }
    }

    public synchronized V get(K key) {

        Node<K, V> node = nodeMap.get(key);
        if(node == null) return null;
        moveToHead(node);
        return node.value;
    }

    private void addToHead(Node<K, V> node) {

        Node<K, V> curr = head.right;
        head.right = node;
        curr.left = node;
        node.left = head;
        node.right = curr;
    }

    private void moveToHead(Node<K, V> node) {

        if(head.right == node) return ;
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node<K, V> node) {

        Node<K, V> prev = node.left, next = node.right;

        node.left = null;
        node.right = null;

        prev.right = next;
        next.left = prev;
    }

    private Node<K, V> removeTail() {

        Node<K, V> node = tail.left;
        removeNode(node);
        return node;
    }
}
