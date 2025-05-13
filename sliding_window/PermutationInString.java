/*
LeetCode 567. Permutation in String

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
*/

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) matches++;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            if (matches == 26) return true;
            int r = s2.charAt(i) - 'a', l = s2.charAt(i - s1.length()) - 'a';
            count2[r]++;
            if (count2[r] == count1[r]) matches++;
            else if (count2[r] == count1[r] + 1) matches--;
            count2[l]--;
            if (count2[l] == count1[l]) matches++;
            else if (count2[l] == count1[l] - 1) matches--;
        }
        return matches == 26;
    }

    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        String s1_1 = "ab";
        String s2_1 = "eidbaooo";
        System.out.println("Input: s1 = \"" + s1_1 + "\", s2 = \"" + s2_1 + "\"");
        boolean result1 = solution.checkInclusion(s1_1, s2_1);
        System.out.println("Output: " + result1); // Expected: true
        
        // Test case 2: No permutation
        System.out.println("\nTest case 2:");
        String s1_2 = "ab";
        String s2_2 = "eidboaoo";
        System.out.println("Input: s1 = \"" + s1_2 + "\", s2 = \"" + s2_2 + "\"");
        boolean result2 = solution.checkInclusion(s1_2, s2_2);
        System.out.println("Output: " + result2); // Expected: false
        
        // Test case 3: Same strings
        System.out.println("\nTest case 3:");
        String s1_3 = "abc";
        String s2_3 = "abc";
        System.out.println("Input: s1 = \"" + s1_3 + "\", s2 = \"" + s2_3 + "\"");
        boolean result3 = solution.checkInclusion(s1_3, s2_3);
        System.out.println("Output: " + result3); // Expected: true
        
        // Test case 4: s1 longer than s2
        System.out.println("\nTest case 4:");
        String s1_4 = "abcd";
        String s2_4 = "abc";
        System.out.println("Input: s1 = \"" + s1_4 + "\", s2 = \"" + s2_4 + "\"");
        boolean result4 = solution.checkInclusion(s1_4, s2_4);
        System.out.println("Output: " + result4); // Expected: false
        
        // Test case 5: Multiple occurrences
        System.out.println("\nTest case 5:");
        String s1_5 = "hello";
        String s2_5 = "ooolleoooleh";
        System.out.println("Input: s1 = \"" + s1_5 + "\", s2 = \"" + s2_5 + "\"");
        boolean result5 = solution.checkInclusion(s1_5, s2_5);
        System.out.println("Output: " + result5); // Expected: false
    }
}

/*
Explanation:
We use two frequency arrays for s1 and the current window in s2. Slide the window and update the counts and matches. If all 26 characters match, return true.
*/ 