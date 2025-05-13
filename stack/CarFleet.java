/*
LeetCode 853. Car Fleet

There are n cars going to the same destination along a one-lane road. The destination is target miles away.
You are given two integer arrays position and speed, both of length n, where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
A car can never pass another car ahead of it, but it can catch up to it, and they will form a car fleet (travel at the same speed).
Return the number of car fleets that will arrive at the destination.

Example 1:
Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3

Example 2:
Input: target = 10, position = [3], speed = [3]
Output: 1

Example 3:
Input: target = 100, position = [0,2,4], speed = [4,2,1]
Output: 1
*/

import java.util.*;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        int fleets = 0;
        double time = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (cars[i][1] > time) {
                fleets++;
                time = cars[i][1];
            }
        }
        return fleets;
    }

    public static void main(String[] args) {
        CarFleet solution = new CarFleet();

        // Test case 1: Example from problem
        int target1 = 12;
        int[] position1 = {10,8,0,5,3};
        int[] speed1 = {2,4,1,1,3};
        System.out.println("Test case 1: " + solution.carFleet(target1, position1, speed1)); // Expected: 3

        // Test case 2: Single car
        int target2 = 10;
        int[] position2 = {3};
        int[] speed2 = {3};
        System.out.println("Test case 2: " + solution.carFleet(target2, position2, speed2)); // Expected: 1

        // Test case 3: All cars form one fleet
        int target3 = 100;
        int[] position3 = {0,2,4};
        int[] speed3 = {4,2,1};
        System.out.println("Test case 3: " + solution.carFleet(target3, position3, speed3)); // Expected: 1

        // Test case 4: No cars
        int target4 = 50;
        int[] position4 = {};
        int[] speed4 = {};
        System.out.println("Test case 4: " + solution.carFleet(target4, position4, speed4)); // Expected: 0

        // Test case 5: Cars with same position
        int target5 = 20;
        int[] position5 = {5,5,5};
        int[] speed5 = {2,3,4};
        System.out.println("Test case 5: " + solution.carFleet(target5, position5, speed5)); // Expected: 1
    }
}

/*
Explanation:
Sort cars by position. Iterate from the car closest to the target. If a car takes longer to reach the target than the car ahead, it forms a new fleet. Otherwise, it joins the fleet ahead.
*/ 