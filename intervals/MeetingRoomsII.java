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
}

/*
Explanation:
Sort the start and end times separately. Use two pointers to track the number of rooms needed. Increment rooms when a meeting starts before the earliest ending meeting ends.
*/ 