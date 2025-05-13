/*
LeetCode 76. Minimum Window Substring

Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"

Example 2:
Input: s = "a", t = "a"
Output: "a"

Example 3:
Input: s = "a", t = "aa"
Output: ""
*/

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int left = 0, minLen = Integer.MAX_VALUE, minStart = 0, count = t.length();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) count--;
                map.put(c, map.get(c) - 1);
            }
            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                char l = s.charAt(left);
                if (map.containsKey(l)) {
                    map.put(l, map.get(l) + 1);
                    if (map.get(l) > 0) count++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\"");
        String result1 = solution.minWindow(s1, t1);
        System.out.println("Output: \"" + result1 + "\""); // Expected: "BANC"
        
        // Test case 2: Single character
        System.out.println("\nTest case 2:");
        String s2 = "a";
        String t2 = "a";
        System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\"");
        String result2 = solution.minWindow(s2, t2);
        System.out.println("Output: \"" + result2 + "\""); // Expected: "a"
        
        // Test case 3: No valid window
        System.out.println("\nTest case 3:");
        String s3 = "a";
        String t3 = "aa";
        System.out.println("Input: s = \"" + s3 + "\", t = \"" + t3 + "\"");
        String result3 = solution.minWindow(s3, t3);
        System.out.println("Output: \"" + result3 + "\""); // Expected: ""
        
        // Test case 4: Multiple occurrences
        System.out.println("\nTest case 4:");
        String s4 = "aab";
        String t4 = "aab";
        System.out.println("Input: s = \"" + s4 + "\", t = \"" + t4 + "\"");
        String result4 = solution.minWindow(s4, t4);
        System.out.println("Output: \"" + result4 + "\""); // Expected: "aab"
        
        // Test case 5: Longer string
        System.out.println("\nTest case 5:");
        String s5 = "cabwefgewcwaefgcf";
        String t5 = "cae";
        System.out.println("Input: s = \"" + s5 + "\", t = \"" + t5 + "\"");
        String result5 = solution.minWindow(s5, t5);
        System.out.println("Output: \"" + result5 + "\""); // Expected: "cwae"
    }
}

/*
Explanation:
We use a sliding window and a HashMap to count the characters in t. Expand the window to the right, and when all characters are covered, try to shrink from the left to find the minimum window.
*/ 