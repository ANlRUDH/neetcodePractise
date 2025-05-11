/*
LeetCode 621. Task Scheduler

Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU can complete either one task or just be idle.
However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter), that is that there must be at least n units of time between any two same tasks.
Return the least number of units of times that the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8

Example 2:
Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6

Example 3:
Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
*/

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) count[c - 'A']++;
        Arrays.sort(count);
        int max = count[25] - 1;
        int idle = max * n;
        for (int i = 24; i >= 0 && count[i] > 0; i--) {
            idle -= Math.min(count[i], max);
        }
        return idle > 0 ? idle + tasks.length : tasks.length;
    }
}

/*
Explanation:
We count the frequency of each task. The most frequent task determines the minimum length. Fill idle slots with other tasks. If idle slots remain, add them to the total.
*/ 