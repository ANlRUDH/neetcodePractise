/*
LeetCode 763. Partition Labels

You are given a string s. Partition the string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation: The partitions are "ababcbaca", "defegde", "hijhklij".

Example 2:
Input: s = "eccbbbbdec"
Output: [10]
*/

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionLabels solution = new PartitionLabels();
        
        // Test case 1: Multiple partitions
        String s1 = "ababcbacadefegdehijhklij";
        System.out.println("Test case 1: " + solution.partitionLabels(s1)); // Expected: [9, 7, 8]
        
        // Test case 2: Single partition
        String s2 = "eccbbbbdec";
        System.out.println("Test case 2: " + solution.partitionLabels(s2)); // Expected: [10]
        
        // Test case 3: Each character in its own partition
        String s3 = "abcdef";
        System.out.println("Test case 3: " + solution.partitionLabels(s3)); // Expected: [1, 1, 1, 1, 1, 1]
        
        // Test case 4: Repeated characters
        String s4 = "aaaaa";
        System.out.println("Test case 4: " + solution.partitionLabels(s4)); // Expected: [5]
        
        // Test case 5: Empty string
        String s5 = "";
        System.out.println("Test case 5: " + solution.partitionLabels(s5)); // Expected: []
    }
}

/*
Explanation:
Track the last occurrence of each character. For each character, update the end of the current partition. When the current index reaches the end, partition and start a new one.
*/ 