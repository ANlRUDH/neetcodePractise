/*
LeetCode 138. Copy List with Random Pointer

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null. Construct a deep copy of the list.

Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
*/

import java.util.HashMap;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;
    Node(int val) { this.val = val; }
}

/*
Explanation:
We use a HashMap to map original nodes to their copies. First pass: create all nodes. Second pass: set next and random pointers using the map.
*/ 