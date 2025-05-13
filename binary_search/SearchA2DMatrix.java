/*
LeetCode 74. Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
- Integers in each row are sorted from left to right.
- The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
*/

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = matrix[mid / n][mid % n];
            if (val == target) return true;
            else if (val < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrix solution = new SearchA2DMatrix();
        
        // Test case 1: Target exists
        int[][] matrix1 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target1 = 3;
        System.out.println("Test case 1: " + solution.searchMatrix(matrix1, target1)); // Expected: true
        
        // Test case 2: Target doesn't exist
        int[][] matrix2 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target2 = 13;
        System.out.println("Test case 2: " + solution.searchMatrix(matrix2, target2)); // Expected: false
        
        // Test case 3: Target at first element
        int[][] matrix3 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target3 = 1;
        System.out.println("Test case 3: " + solution.searchMatrix(matrix3, target3)); // Expected: true
        
        // Test case 4: Target at last element
        int[][] matrix4 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target4 = 60;
        System.out.println("Test case 4: " + solution.searchMatrix(matrix4, target4)); // Expected: true
        
        // Test case 5: Single element matrix
        int[][] matrix5 = {{1}};
        int target5 = 1;
        System.out.println("Test case 5: " + solution.searchMatrix(matrix5, target5)); // Expected: true
    }
}

/*
Explanation:
Treat the 2D matrix as a 1D sorted array and apply binary search. Map the 1D index to 2D coordinates using (mid / n, mid % n).
*/ 