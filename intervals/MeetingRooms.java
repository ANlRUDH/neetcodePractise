/*
LeetCode 252. Meeting Rooms

Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: true
*/

import java.util.*;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();
        
        // Test case 1: Overlapping meetings
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Test case 1: " + solution.canAttendMeetings(intervals1)); // Expected: false
        
        // Test case 2: Non-overlapping meetings
        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Test case 2: " + solution.canAttendMeetings(intervals2)); // Expected: true
        
        // Test case 3: Single meeting
        int[][] intervals3 = {{1, 2}};
        System.out.println("Test case 3: " + solution.canAttendMeetings(intervals3)); // Expected: true
        
        // Test case 4: Empty array
        int[][] intervals4 = {};
        System.out.println("Test case 4: " + solution.canAttendMeetings(intervals4)); // Expected: true
        
        // Test case 5: Back-to-back meetings
        int[][] intervals5 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println("Test case 5: " + solution.canAttendMeetings(intervals5)); // Expected: true
    }
}

/*
Explanation:
Sort the intervals by start time. If any meeting starts before the previous one ends, return false. Otherwise, return true.
*/ 