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
}

/*
Explanation:
We use backtracking to build the string. We can add '(' if we still have some left, and ')' if it won't exceed the number of '('. When the string is of length 2*n, we add it to the result.
*/ 