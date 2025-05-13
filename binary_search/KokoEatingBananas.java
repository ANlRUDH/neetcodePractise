/*
LeetCode 875. Koko Eating Bananas

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses a pile and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and won't eat any more bananas during this hour.
Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23
*/

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) right = Math.max(right, pile);
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }
            if (hours > h) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        KokoEatingBananas solution = new KokoEatingBananas();
        
        // Test case 1: Basic case
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println("Test case 1: " + solution.minEatingSpeed(piles1, h1)); // Expected: 4
        
        // Test case 2: Larger piles
        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println("Test case 2: " + solution.minEatingSpeed(piles2, h2)); // Expected: 30
        
        // Test case 3: More hours available
        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println("Test case 3: " + solution.minEatingSpeed(piles3, h3)); // Expected: 23
        
        // Test case 4: Single pile
        int[] piles4 = {10};
        int h4 = 2;
        System.out.println("Test case 4: " + solution.minEatingSpeed(piles4, h4)); // Expected: 5
        
        // Test case 5: Equal piles
        int[] piles5 = {5, 5, 5, 5};
        int h5 = 4;
        System.out.println("Test case 5: " + solution.minEatingSpeed(piles5, h5)); // Expected: 5
    }
}

/*
Explanation:
We use binary search on the possible eating speeds. For each speed, calculate the total hours needed. If it exceeds h, increase the speed; otherwise, try a lower speed.
*/ 