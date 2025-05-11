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
}

/*
Explanation:
We use two frequency arrays for s1 and the current window in s2. Slide the window and update the counts and matches. If all 26 characters match, return true.
*/ 