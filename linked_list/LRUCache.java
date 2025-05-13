/*
LeetCode 146. LRU Cache

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:
- LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
- int get(int key) Return the value of the key if the key exists, otherwise return -1.
- void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

Example 1:
Input: ["LRUCache","put","put","get","put","get","put","get","get","get"], [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
Output: [null,null,null,1,null,-1,null,-1,3,4]
*/

import java.util.*;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private static class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Helper method to print cache contents
    private void printCache() {
        System.out.print("Cache contents: ");
        Node curr = head.next;
        while (curr != tail) {
            System.out.print("(" + curr.key + "," + curr.value + ") ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test case 1: Basic operations
        System.out.println("Test case 1:");
        LRUCache cache1 = new LRUCache(2);
        System.out.println("Created cache with capacity 2");
        cache1.put(1, 1);
        System.out.println("put(1, 1)");
        cache1.printCache();
        cache1.put(2, 2);
        System.out.println("put(2, 2)");
        cache1.printCache();
        System.out.println("get(1) = " + cache1.get(1)); // Expected: 1
        cache1.put(3, 3);
        System.out.println("put(3, 3)");
        cache1.printCache();
        System.out.println("get(2) = " + cache1.get(2)); // Expected: -1
        cache1.put(4, 4);
        System.out.println("put(4, 4)");
        cache1.printCache();
        System.out.println("get(1) = " + cache1.get(1)); // Expected: -1
        System.out.println("get(3) = " + cache1.get(3)); // Expected: 3
        System.out.println("get(4) = " + cache1.get(4)); // Expected: 4
        
        // Test case 2: Update existing key
        System.out.println("\nTest case 2:");
        LRUCache cache2 = new LRUCache(2);
        System.out.println("Created cache with capacity 2");
        cache2.put(1, 1);
        System.out.println("put(1, 1)");
        cache2.printCache();
        cache2.put(1, 2);
        System.out.println("put(1, 2)");
        cache2.printCache();
        System.out.println("get(1) = " + cache2.get(1)); // Expected: 2
        
        // Test case 3: Single capacity
        System.out.println("\nTest case 3:");
        LRUCache cache3 = new LRUCache(1);
        System.out.println("Created cache with capacity 1");
        cache3.put(1, 1);
        System.out.println("put(1, 1)");
        cache3.printCache();
        cache3.put(2, 2);
        System.out.println("put(2, 2)");
        cache3.printCache();
        System.out.println("get(1) = " + cache3.get(1)); // Expected: -1
        System.out.println("get(2) = " + cache3.get(2)); // Expected: 2
        
        // Test case 4: Multiple gets
        System.out.println("\nTest case 4:");
        LRUCache cache4 = new LRUCache(3);
        System.out.println("Created cache with capacity 3");
        cache4.put(1, 1);
        cache4.put(2, 2);
        cache4.put(3, 3);
        System.out.println("Added three items");
        cache4.printCache();
        System.out.println("get(2) = " + cache4.get(2)); // Expected: 2
        cache4.printCache();
        cache4.put(4, 4);
        System.out.println("put(4, 4)");
        cache4.printCache();
        System.out.println("get(1) = " + cache4.get(1)); // Expected: -1
        
        // Test case 5: Large capacity
        System.out.println("\nTest case 5:");
        LRUCache cache5 = new LRUCache(5);
        System.out.println("Created cache with capacity 5");
        for (int i = 1; i <= 5; i++) {
            cache5.put(i, i * 10);
            System.out.println("put(" + i + ", " + (i * 10) + ")");
        }
        cache5.printCache();
        System.out.println("get(3) = " + cache5.get(3)); // Expected: 30
        cache5.put(6, 60);
        System.out.println("put(6, 60)");
        cache5.printCache();
        System.out.println("get(1) = " + cache5.get(1)); // Expected: -1
    }
}

/*
Explanation:
We use a doubly linked list and a HashMap. The list keeps track of the usage order, and the map provides O(1) access. On get/put, move the node to the front. Remove from the end if over capacity.
*/ 