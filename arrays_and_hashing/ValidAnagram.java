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
}

/*
Explanation:
We use an integer array of size 26 to count the frequency of each character in the first string, then decrement the count for each character in the second string. If all counts are zero at the end, the strings are anagrams.
*/ 