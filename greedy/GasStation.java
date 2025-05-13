/*
LeetCode 134. Gas Station

There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i], and the cost to travel to the next station is cost[i].
Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.

Example 1:
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3

Example 2:
Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
*/

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, curr = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }
        return total < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        GasStation solution = new GasStation();
        
        // Test case 1: Valid circuit
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println("Test case 1: " + solution.canCompleteCircuit(gas1, cost1)); // Expected: 3
        
        // Test case 2: No valid circuit
        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println("Test case 2: " + solution.canCompleteCircuit(gas2, cost2)); // Expected: -1
        
        // Test case 3: Single station
        int[] gas3 = {2};
        int[] cost3 = {2};
        System.out.println("Test case 3: " + solution.canCompleteCircuit(gas3, cost3)); // Expected: 0
        
        // Test case 4: Start at first station
        int[] gas4 = {5, 1, 2, 3, 4};
        int[] cost4 = {4, 4, 1, 5, 1};
        System.out.println("Test case 4: " + solution.canCompleteCircuit(gas4, cost4)); // Expected: 0
        
        // Test case 5: Equal gas and cost
        int[] gas5 = {1, 1, 1, 1};
        int[] cost5 = {1, 1, 1, 1};
        System.out.println("Test case 5: " + solution.canCompleteCircuit(gas5, cost5)); // Expected: 0
    }
}

/*
Explanation:
If the total gas is less than the total cost, it's impossible. Otherwise, the answer is the start index after the last failed segment.
*/ 