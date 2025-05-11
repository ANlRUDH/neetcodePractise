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
}

/*
Explanation:
We use a sliding window and a HashMap to count the characters in t. Expand the window to the right, and when all characters are covered, try to shrink from the left to find the minimum window.
*/ 