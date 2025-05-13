/*
LeetCode 20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
*/

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        // Test case 1: Simple valid
        String s1 = "()";
        System.out.println("Test case 1: " + solution.isValid(s1)); // Expected: true

        // Test case 2: Multiple valid types
        String s2 = "()[]{}";
        System.out.println("Test case 2: " + solution.isValid(s2)); // Expected: true

        // Test case 3: Invalid mixed
        String s3 = "(]";
        System.out.println("Test case 3: " + solution.isValid(s3)); // Expected: false

        // Test case 4: Nested valid
        String s4 = "{[()]}";
        System.out.println("Test case 4: " + solution.isValid(s4)); // Expected: true

        // Test case 5: Unmatched open
        String s5 = "((";
        System.out.println("Test case 5: " + solution.isValid(s5)); // Expected: false

        // Test case 6: Unmatched close
        String s6 = ")}";
        System.out.println("Test case 6: " + solution.isValid(s6)); // Expected: false

        // Test case 7: Empty string
        String s7 = "";
        System.out.println("Test case 7: " + solution.isValid(s7)); // Expected: true
    }
}

/*
Explanation:
We use a stack to keep track of opening brackets. For each closing bracket, we check if it matches the top of the stack. If not, or if the stack is empty, the string is invalid. At the end, the stack should be empty for a valid string.
*/ 