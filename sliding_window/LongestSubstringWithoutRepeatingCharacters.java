/*
LeetCode 3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
*/

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        String s1 = "abcabcbb";
        System.out.println("Input: s = \"" + s1 + "\"");
        int result1 = solution.lengthOfLongestSubstring(s1);
        System.out.println("Output: " + result1); // Expected: 3
        
        // Test case 2: All same characters
        System.out.println("\nTest case 2:");
        String s2 = "bbbbb";
        System.out.println("Input: s = \"" + s2 + "\"");
        int result2 = solution.lengthOfLongestSubstring(s2);
        System.out.println("Output: " + result2); // Expected: 1
        
        // Test case 3: Multiple non-repeating substrings
        System.out.println("\nTest case 3:");
        String s3 = "pwwkew";
        System.out.println("Input: s = \"" + s3 + "\"");
        int result3 = solution.lengthOfLongestSubstring(s3);
        System.out.println("Output: " + result3); // Expected: 3
        
        // Test case 4: Empty string
        System.out.println("\nTest case 4:");
        String s4 = "";
        System.out.println("Input: s = \"" + s4 + "\"");
        int result4 = solution.lengthOfLongestSubstring(s4);
        System.out.println("Output: " + result4); // Expected: 0
        
        // Test case 5: Single character
        System.out.println("\nTest case 5:");
        String s5 = "a";
        System.out.println("Input: s = \"" + s5 + "\"");
        int result5 = solution.lengthOfLongestSubstring(s5);
        System.out.println("Output: " + result5); // Expected: 1
    }
}

/*
Explanation:
We use a sliding window and a HashMap to track the last index of each character. Move the left pointer to avoid duplicates and update the maximum length.
*/ 