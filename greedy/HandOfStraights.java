/*
LeetCode 846. Hand of Straights

Alice has a hand of cards, each represented by an integer. She wants to rearrange the cards into groups so that each group is size groupSize, and consists of groupSize consecutive cards.
Return true if and only if she can.

Example 1:
Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

Example 2:
Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand cannot be rearranged into groups of 4.
*/

import java.util.*;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int card : hand) count.put(card, count.getOrDefault(card, 0) + 1);
        while (!count.isEmpty()) {
            int first = count.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int card = first + i;
                if (!count.containsKey(card)) return false;
                count.put(card, count.get(card) - 1);
                if (count.get(card) == 0) count.remove(card);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HandOfStraights solution = new HandOfStraights();
        
        // Test case 1: Valid hand
        int[] hand1 = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize1 = 3;
        System.out.println("Test case 1: " + solution.isNStraightHand(hand1, groupSize1)); // Expected: true
        
        // Test case 2: Invalid hand
        int[] hand2 = {1, 2, 3, 4, 5};
        int groupSize2 = 4;
        System.out.println("Test case 2: " + solution.isNStraightHand(hand2, groupSize2)); // Expected: false
        
        // Test case 3: Single group
        int[] hand3 = {1, 2, 3};
        int groupSize3 = 3;
        System.out.println("Test case 3: " + solution.isNStraightHand(hand3, groupSize3)); // Expected: true
        
        // Test case 4: Group size 1
        int[] hand4 = {1, 2, 3, 4};
        int groupSize4 = 1;
        System.out.println("Test case 4: " + solution.isNStraightHand(hand4, groupSize4)); // Expected: true
        
        // Test case 5: Non-consecutive cards
        int[] hand5 = {1, 2, 3, 5, 6, 7};
        int groupSize5 = 3;
        System.out.println("Test case 5: " + solution.isNStraightHand(hand5, groupSize5)); // Expected: false
    }
}

/*
Explanation:
Use a TreeMap to count cards. Always try to form a group starting from the smallest card. Remove cards as they are used. If you can't form a group, return false.
*/ 