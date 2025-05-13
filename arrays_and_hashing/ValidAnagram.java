/*
LeetCode 242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
*/

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c : t.toCharArray()) count[c - 'a']--;
        for (int n : count) if (n != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        
        // Test case 1: Valid anagram
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Test case 1: " + solution.isAnagram(s1, t1)); // Expected: true
        
        // Test case 2: Invalid anagram
        String s2 = "rat";
        String t2 = "car";
        System.out.println("Test case 2: " + solution.isAnagram(s2, t2)); // Expected: false
        
        // Test case 3: Empty strings
        String s3 = "";
        String t3 = "";
        System.out.println("Test case 3: " + solution.isAnagram(s3, t3)); // Expected: true
        
        // Test case 4: Different lengths
        String s4 = "hello";
        String t4 = "world";
        System.out.println("Test case 4: " + solution.isAnagram(s4, t4)); // Expected: false
    }
}

/*
Explanation:
We use an integer array of size 26 to count the frequency of each character in the first string, then decrement the count for each character in the second string. If all counts are zero at the end, the strings are anagrams.
*/ 