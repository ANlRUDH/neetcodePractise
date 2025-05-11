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
}

/*
Explanation:
If the total gas is less than the total cost, it's impossible. Otherwise, the answer is the start index after the last failed segment.
*/ 