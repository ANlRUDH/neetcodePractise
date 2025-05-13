/*
LeetCode 678. Valid Parenthesis String

Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
The '*' can be treated as '(', ')' or an empty string.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "(*)"
Output: true

Example 3:
Input: s = "(*))"
Output: true
*/

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                if (low > 0) low--;
                high--;
            } else { // '*'
                if (low > 0) low--;
                high++;
            }
            if (high < 0) return false;
        }
        return low == 0;
    }

    public static void main(String[] args) {
        ValidParenthesisString solution = new ValidParenthesisString();
        
        // Test case 1: Basic valid case
        String s1 = "()";
        System.out.println("Test case 1: " + solution.checkValidString(s1)); // Expected: true
        
        // Test case 2: With wildcard
        String s2 = "(*)";
        System.out.println("Test case 2: " + solution.checkValidString(s2)); // Expected: true
        
        // Test case 3: Multiple wildcards
        String s3 = "(*))";
        System.out.println("Test case 3: " + solution.checkValidString(s3)); // Expected: true
        
        // Test case 4: Invalid case
        String s4 = "((*";
        System.out.println("Test case 4: " + solution.checkValidString(s4)); // Expected: false
        
        // Test case 5: Complex valid case
        String s5 = "((*)";
        System.out.println("Test case 5: " + solution.checkValidString(s5)); // Expected: true
    }
}

/*
Explanation:
Use two counters to track the possible range of open parentheses. '*' can increase or decrease the range. If the range is valid at the end, the string is valid.
*/ 