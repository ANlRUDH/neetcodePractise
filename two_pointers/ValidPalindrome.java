/*
LeetCode 125. Valid Palindrome

Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
*/

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        
        // Test case 1: Basic palindrome with spaces and punctuation
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Test case 1: " + solution.isPalindrome(s1)); // Expected: true
        
        // Test case 2: Non-palindrome with spaces
        String s2 = "race a car";
        System.out.println("Test case 2: " + solution.isPalindrome(s2)); // Expected: false
        
        // Test case 3: Empty string
        String s3 = "";
        System.out.println("Test case 3: " + solution.isPalindrome(s3)); // Expected: true
        
        // Test case 4: Single character
        String s4 = "a";
        System.out.println("Test case 4: " + solution.isPalindrome(s4)); // Expected: true
        
        // Test case 5: String with only non-alphanumeric characters
        String s5 = ".,";
        System.out.println("Test case 5: " + solution.isPalindrome(s5)); // Expected: true
        
        // Test case 6: Mixed case palindrome
        String s6 = "Was it a car or a cat I saw?";
        System.out.println("Test case 6: " + solution.isPalindrome(s6)); // Expected: true
    }
}

/*
Explanation:
We use two pointers, one starting from the beginning and one from the end, skipping non-alphanumeric characters and comparing the characters in a case-insensitive manner.
*/ 