/*
LeetCode 167. Two Sum II - Input Array Is Sorted

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
You may not use the same element twice.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2.

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
*/

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted solution = new TwoSumIIInputArrayIsSorted();
        
        // Test case 1: Basic case
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(numbers1, target1);
        System.out.println("Test case 1: [" + result1[0] + ", " + result1[1] + "]"); // Expected: [1, 2]
        
        // Test case 2: Numbers in middle of array
        int[] numbers2 = {2, 3, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(numbers2, target2);
        System.out.println("Test case 2: [" + result2[0] + ", " + result2[1] + "]"); // Expected: [1, 3]
        
        // Test case 3: Negative numbers
        int[] numbers3 = {-1, 0};
        int target3 = -1;
        int[] result3 = solution.twoSum(numbers3, target3);
        System.out.println("Test case 3: [" + result3[0] + ", " + result3[1] + "]"); // Expected: [1, 2]
        
        // Test case 4: Larger array
        int[] numbers4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target4 = 15;
        int[] result4 = solution.twoSum(numbers4, target4);
        System.out.println("Test case 4: [" + result4[0] + ", " + result4[1] + "]"); // Expected: [5, 10]
        
        // Test case 5: Duplicate numbers
        int[] numbers5 = {1, 2, 2, 3, 4};
        int target5 = 4;
        int[] result5 = solution.twoSum(numbers5, target5);
        System.out.println("Test case 5: [" + result5[0] + ", " + result5[1] + "]"); // Expected: [2, 3]
    }
}

/*
Explanation:
We use two pointers, one at the start and one at the end of the array. If the sum is less than the target, move the left pointer right. If the sum is greater, move the right pointer left. If the sum matches, return the indices (1-based).
*/ 