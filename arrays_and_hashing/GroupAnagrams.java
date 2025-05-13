/*
LeetCode 49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
*/

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        
        // Test case 1: Multiple groups of anagrams
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = solution.groupAnagrams(strs1);
        System.out.println("Test case 1:");
        for (List<String> group : result1) {
            System.out.println(group);
        }
        
        // Test case 2: Empty string
        String[] strs2 = {""};
        List<List<String>> result2 = solution.groupAnagrams(strs2);
        System.out.println("\nTest case 2:");
        for (List<String> group : result2) {
            System.out.println(group);
        }
        
        // Test case 3: Single character
        String[] strs3 = {"a"};
        List<List<String>> result3 = solution.groupAnagrams(strs3);
        System.out.println("\nTest case 3:");
        for (List<String> group : result3) {
            System.out.println(group);
        }
        
        // Test case 4: No anagrams
        String[] strs4 = {"abc", "def", "ghi"};
        List<List<String>> result4 = solution.groupAnagrams(strs4);
        System.out.println("\nTest case 4:");
        for (List<String> group : result4) {
            System.out.println(group);
        }
    }
}

/*
Explanation:
We use a HashMap to group strings by their sorted character array (which is the same for all anagrams). For each string, we sort its characters and use the sorted string as a key. All anagrams will map to the same key.
*/ 