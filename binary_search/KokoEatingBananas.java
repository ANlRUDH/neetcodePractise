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
}

/*
Explanation:
We use binary search on the possible eating speeds. For each speed, calculate the total hours needed. If it exceeds h, increase the speed; otherwise, try a lower speed.
*/ 