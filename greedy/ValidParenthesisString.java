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
}

/*
Explanation:
Use two counters to track the possible range of open parentheses. '*' can increase or decrease the range. If the range is valid at the end, the string is valid.
*/ 