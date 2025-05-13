/*
LeetCode 150. Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22
*/

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

        // Test case 1: Example from problem
        String[] tokens1 = {"2","1","+","3","*"};
        System.out.println("Test case 1: " + solution.evalRPN(tokens1)); // Expected: 9

        // Test case 2: Division example
        String[] tokens2 = {"4","13","5","/","+"};
        System.out.println("Test case 2: " + solution.evalRPN(tokens2)); // Expected: 6

        // Test case 3: Complex expression
        String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Test case 3: " + solution.evalRPN(tokens3)); // Expected: 22

        // Test case 4: Single number
        String[] tokens4 = {"42"};
        System.out.println("Test case 4: " + solution.evalRPN(tokens4)); // Expected: 42

        // Test case 5: Empty array
        String[] tokens5 = {};
        System.out.println("Test case 5: " + solution.evalRPN(tokens5)); // Expected: 0 (or error, depending on implementation)
    }
}

/*
Explanation:
We use a stack to evaluate the expression. For each token, if it's a number, push it to the stack. If it's an operator, pop two numbers, apply the operator, and push the result back. The final result is the only value left in the stack.
*/ 