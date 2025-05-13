/*
LeetCode 424. Longest Repeating Character Replacement

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
*/

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxCount = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println("Input: s = \"" + s1 + "\", k = " + k1);
        int result1 = solution.characterReplacement(s1, k1);
        System.out.println("Output: " + result1); // Expected: 4
        
        // Test case 2: Single replacement
        System.out.println("\nTest case 2:");
        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println("Input: s = \"" + s2 + "\", k = " + k2);
        int result2 = solution.characterReplacement(s2, k2);
        System.out.println("Output: " + result2); // Expected: 4
        
        // Test case 3: No replacements needed
        System.out.println("\nTest case 3:");
        String s3 = "AAAA";
        int k3 = 0;
        System.out.println("Input: s = \"" + s3 + "\", k = " + k3);
        int result3 = solution.characterReplacement(s3, k3);
        System.out.println("Output: " + result3); // Expected: 4
        
        // Test case 4: All replacements possible
        System.out.println("\nTest case 4:");
        String s4 = "ABCDE";
        int k4 = 4;
        System.out.println("Input: s = \"" + s4 + "\", k = " + k4);
        int result4 = solution.characterReplacement(s4, k4);
        System.out.println("Output: " + result4); // Expected: 5
        
        // Test case 5: Alternating characters
        System.out.println("\nTest case 5:");
        String s5 = "ABABABAB";
        int k5 = 2;
        System.out.println("Input: s = \"" + s5 + "\", k = " + k5);
        int result5 = solution.characterReplacement(s5, k5);
        System.out.println("Output: " + result5); // Expected: 6
    }
}

/*
Explanation:
We use a sliding window and keep track of the count of the most frequent character in the window. If the window size minus the max count is greater than k, shrink the window from the left.
*/ 