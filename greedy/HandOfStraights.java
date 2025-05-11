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
}

/*
Explanation:
Use a TreeMap to count cards. Always try to form a group starting from the smallest card. Remove cards as they are used. If you can't form a group, return false.
*/ 