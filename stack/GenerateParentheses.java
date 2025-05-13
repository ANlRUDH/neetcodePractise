/*
LeetCode 22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
*/

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }
    private void backtrack(List<String> res, String curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            res.add(curr);
            return;
        }
        if (open < max) backtrack(res, curr + "(", open + 1, close, max);
        if (close < open) backtrack(res, curr + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();

        // Test case 1: n = 3
        int n1 = 3;
        List<String> result1 = solution.generateParenthesis(n1);
        System.out.println("Test case 1: " + result1); // Expected: ["((()))","(()())","(())()","()(())","()()()"]

        // Test case 2: n = 1
        int n2 = 1;
        List<String> result2 = solution.generateParenthesis(n2);
        System.out.println("Test case 2: " + result2); // Expected: ["()"]

        // Test case 3: n = 0
        int n3 = 0;
        List<String> result3 = solution.generateParenthesis(n3);
        System.out.println("Test case 3: " + result3); // Expected: []

        // Test case 4: n = 2
        int n4 = 2;
        List<String> result4 = solution.generateParenthesis(n4);
        System.out.println("Test case 4: " + result4); // Expected: ["(())","()()"]
    }
}

/*
Explanation:
We use backtracking to build the string. We can add '(' if we still have some left, and ')' if it won't exceed the number of '('. When the string is of length 2*n, we add it to the result.
*/ 