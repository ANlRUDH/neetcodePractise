/*
LeetCode 271. Encode and Decode Strings

Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Example 1:
Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]

Example 2:
Input: ["we","say",":","yes"]
Output: ["we","say",":","yes"]
*/

import java.util.*;

public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') j++;
            int len = Integer.parseInt(s.substring(i, j));
            res.add(s.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }
        return res;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings solution = new EncodeAndDecodeStrings();
        
        // Test case 1: Basic case
        List<String> strs1 = Arrays.asList("lint", "code", "love", "you");
        String encoded1 = solution.encode(strs1);
        List<String> decoded1 = solution.decode(encoded1);
        System.out.println("Test case 1:");
        System.out.println("Original: " + strs1);
        System.out.println("Encoded: " + encoded1);
        System.out.println("Decoded: " + decoded1);
        
        // Test case 2: Strings with special characters
        List<String> strs2 = Arrays.asList("we", "say", ":", "yes");
        String encoded2 = solution.encode(strs2);
        List<String> decoded2 = solution.decode(encoded2);
        System.out.println("\nTest case 2:");
        System.out.println("Original: " + strs2);
        System.out.println("Encoded: " + encoded2);
        System.out.println("Decoded: " + decoded2);
        
        // Test case 3: Empty strings
        List<String> strs3 = Arrays.asList("", "", "");
        String encoded3 = solution.encode(strs3);
        List<String> decoded3 = solution.decode(encoded3);
        System.out.println("\nTest case 3:");
        System.out.println("Original: " + strs3);
        System.out.println("Encoded: " + encoded3);
        System.out.println("Decoded: " + decoded3);
        
        // Test case 4: Single string
        List<String> strs4 = Arrays.asList("hello");
        String encoded4 = solution.encode(strs4);
        List<String> decoded4 = solution.decode(encoded4);
        System.out.println("\nTest case 4:");
        System.out.println("Original: " + strs4);
        System.out.println("Encoded: " + encoded4);
        System.out.println("Decoded: " + decoded4);
    }
}

/*
Explanation:
To encode, for each string, we prepend its length and a delimiter (e.g., '#'). To decode, we parse the length, extract the substring, and repeat until the end of the string.
*/ 