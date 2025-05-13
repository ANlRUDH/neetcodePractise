/*
LeetCode 155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:
- MinStack() initializes the stack object.
- void push(int val) pushes the element val onto the stack.
- void pop() removes the element on the top of the stack.
- int top() gets the top element of the stack.
- int getMin() retrieves the minimum element in the stack.

Example 1:
Input: ["MinStack","push","push","push","getMin","pop","top","getMin"]
        [[],[-2],[0],[-3],[],[],[],[]]
Output: [null,null,null,null,-3,null,0,-2]
*/

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        // Test case 1: Push and getMin
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Test case 1 - getMin: " + minStack.getMin()); // Expected: -3

        // Test case 2: Pop and top
        minStack.pop();
        System.out.println("Test case 2 - top: " + minStack.top()); // Expected: 0

        // Test case 3: getMin after pop
        System.out.println("Test case 3 - getMin: " + minStack.getMin()); // Expected: -2

        // Test case 4: Push same value
        minStack.push(-2);
        minStack.push(-2);
        System.out.println("Test case 4 - getMin: " + minStack.getMin()); // Expected: -2

        // Test case 5: Pop all elements
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println("Test case 5 - Stack should be empty");
    }
}

/*
Explanation:
We use two stacks: one for all values and one for the minimums. When pushing, also push to minStack if the value is <= current min. When popping, pop from minStack if the value equals the min. This allows O(1) min retrieval.
*/ 