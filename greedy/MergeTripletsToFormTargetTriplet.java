/*
LeetCode 1899. Merge Triplets to Form Target Triplet

A triplet is an array of three integers. You are given a 2D integer array triplets and an integer array target of length 3. You can select some triplets and update them to become the maximum of the selected triplets. Return true if it is possible to obtain the target triplet.

Example 1:
Input: triplets = [[2,5,3],[1,8,4],[1,7,5]], target = [2,7,5]
Output: true

Example 2:
Input: triplets = [[3,4,5],[4,5,6]], target = [3,2,5]
Output: false

Example 3:
Input: triplets = [[2,5,3],[2,3,4],[1,2,5],[5,2,3]], target = [5,5,5]
Output: true
*/

public class MergeTripletsToFormTargetTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] found = new boolean[3];
        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) continue;
            if (t[0] == target[0]) found[0] = true;
            if (t[1] == target[1]) found[1] = true;
            if (t[2] == target[2]) found[2] = true;
        }
        return found[0] && found[1] && found[2];
    }

    public static void main(String[] args) {
        MergeTripletsToFormTargetTriplet solution = new MergeTripletsToFormTargetTriplet();
        
        // Test case 1: Valid triplets
        int[][] triplets1 = {{2, 5, 3}, {1, 8, 4}, {1, 7, 5}};
        int[] target1 = {2, 7, 5};
        System.out.println("Test case 1: " + solution.mergeTriplets(triplets1, target1)); // Expected: true
        
        // Test case 2: Invalid triplets
        int[][] triplets2 = {{3, 4, 5}, {4, 5, 6}};
        int[] target2 = {3, 2, 5};
        System.out.println("Test case 2: " + solution.mergeTriplets(triplets2, target2)); // Expected: false
        
        // Test case 3: All equal target
        int[][] triplets3 = {{2, 5, 3}, {2, 3, 4}, {1, 2, 5}, {5, 2, 3}};
        int[] target3 = {5, 5, 5};
        System.out.println("Test case 3: " + solution.mergeTriplets(triplets3, target3)); // Expected: true
        
        // Test case 4: Single triplet
        int[][] triplets4 = {{1, 1, 1}};
        int[] target4 = {1, 1, 1};
        System.out.println("Test case 4: " + solution.mergeTriplets(triplets4, target4)); // Expected: true
        
        // Test case 5: No matching values
        int[][] triplets5 = {{1, 1, 1}, {2, 2, 2}};
        int[] target5 = {3, 3, 3};
        System.out.println("Test case 5: " + solution.mergeTriplets(triplets5, target5)); // Expected: false
    }
}

/*
Explanation:
For each triplet, if all elements are less than or equal to the target, mark which target values are matched. If all three are matched, return true.
*/ 