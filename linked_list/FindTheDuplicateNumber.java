/*
LeetCode 287. Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive, there is only one repeated number in nums. Return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3
*/

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // Helper method to print an array
    private void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber solution = new FindTheDuplicateNumber();
        
        // Test case 1: Basic case
        System.out.println("Test case 1:");
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.print("Array: ");
        solution.printArray(nums1);
        System.out.println("Duplicate number: " + solution.findDuplicate(nums1)); // Expected: 2
        
        // Test case 2: Duplicate at different positions
        System.out.println("\nTest case 2:");
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.print("Array: ");
        solution.printArray(nums2);
        System.out.println("Duplicate number: " + solution.findDuplicate(nums2)); // Expected: 3
        
        // Test case 3: Duplicate at start
        System.out.println("\nTest case 3:");
        int[] nums3 = {2, 2, 2, 2, 2};
        System.out.print("Array: ");
        solution.printArray(nums3);
        System.out.println("Duplicate number: " + solution.findDuplicate(nums3)); // Expected: 2
        
        // Test case 4: Duplicate at end
        System.out.println("\nTest case 4:");
        int[] nums4 = {1, 2, 3, 4, 4};
        System.out.print("Array: ");
        solution.printArray(nums4);
        System.out.println("Duplicate number: " + solution.findDuplicate(nums4)); // Expected: 4
        
        // Test case 5: Larger array
        System.out.println("\nTest case 5:");
        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 5};
        System.out.print("Array: ");
        solution.printArray(nums5);
        System.out.println("Duplicate number: " + solution.findDuplicate(nums5)); // Expected: 5
    }
}

/*
Explanation:
We use Floyd's Tortoise and Hare (cycle detection) algorithm. Treat the array as a linked list where the value points to the next index. The duplicate forms a cycle.
*/ 