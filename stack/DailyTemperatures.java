/*
LeetCode 739. Daily Temperatures

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
*/

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();

        // Test case 1: Example from problem
        int[] temperatures1 = {73,74,75,71,69,72,76,73};
        int[] result1 = solution.dailyTemperatures(temperatures1);
        System.out.println("Test case 1: " + java.util.Arrays.toString(result1)); // Expected: [1,1,4,2,1,1,0,0]

        // Test case 2: Increasing temperatures
        int[] temperatures2 = {30,40,50,60};
        int[] result2 = solution.dailyTemperatures(temperatures2);
        System.out.println("Test case 2: " + java.util.Arrays.toString(result2)); // Expected: [1,1,1,0]

        // Test case 3: Decreasing temperatures
        int[] temperatures3 = {30,60,90};
        int[] result3 = solution.dailyTemperatures(temperatures3);
        System.out.println("Test case 3: " + java.util.Arrays.toString(result3)); // Expected: [1,1,0]

        // Test case 4: All same temperature
        int[] temperatures4 = {50,50,50,50};
        int[] result4 = solution.dailyTemperatures(temperatures4);
        System.out.println("Test case 4: " + java.util.Arrays.toString(result4)); // Expected: [0,0,0,0]

        // Test case 5: Single temperature
        int[] temperatures5 = {70};
        int[] result5 = solution.dailyTemperatures(temperatures5);
        System.out.println("Test case 5: " + java.util.Arrays.toString(result5)); // Expected: [0]

        // Test case 6: Empty array
        int[] temperatures6 = {};
        int[] result6 = solution.dailyTemperatures(temperatures6);
        System.out.println("Test case 6: " + java.util.Arrays.toString(result6)); // Expected: []
    }
}

/*
Explanation:
We use a stack to keep indices of the days. For each day, we pop from the stack until we find a warmer day, and calculate the difference in days. If no warmer day is found, the answer remains 0.
*/ 