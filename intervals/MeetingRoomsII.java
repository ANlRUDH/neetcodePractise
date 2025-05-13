/*
LeetCode 253. Meeting Rooms II

Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: 1
*/

import java.util.*;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0, endPtr = 0;
        for (int i = 0; i < n; i++) {
            if (start[i] < end[endPtr]) {
                rooms++;
            } else {
                endPtr++;
            }
        }
        return rooms;
    }

    public static void main(String[] args) {
        MeetingRoomsII solution = new MeetingRoomsII();
        
        // Test case 1: Multiple overlapping meetings
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Test case 1: " + solution.minMeetingRooms(intervals1)); // Expected: 2
        
        // Test case 2: Non-overlapping meetings
        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Test case 2: " + solution.minMeetingRooms(intervals2)); // Expected: 1
        
        // Test case 3: Single meeting
        int[][] intervals3 = {{1, 2}};
        System.out.println("Test case 3: " + solution.minMeetingRooms(intervals3)); // Expected: 1
        
        // Test case 4: Empty array
        int[][] intervals4 = {};
        System.out.println("Test case 4: " + solution.minMeetingRooms(intervals4)); // Expected: 0
        
        // Test case 5: All meetings overlap
        int[][] intervals5 = {{1, 3}, {2, 4}, {3, 5}};
        System.out.println("Test case 5: " + solution.minMeetingRooms(intervals5)); // Expected: 2
    }
}

/*
Explanation:
Sort the start and end times separately. Use two pointers to track the number of rooms needed. Increment rooms when a meeting starts before the earliest ending meeting ends.
*/ 