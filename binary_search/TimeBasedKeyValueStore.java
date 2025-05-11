/*
LeetCode 981. Time Based Key-Value Store

Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:
- TimeMap() Initializes the object of the data structure.
- void set(String key, String value, int timestamp) Stores the key and value, along with the given timestamp.
- String get(String key, int timestamp) Returns a value such that set was called previously with timestamp_prev <= timestamp. If there are multiple such values, it returns the one with the largest timestamp_prev. If there are no values, it returns "".

Example 1:
Input: ["TimeMap","set","get","get","set","get","get"], [["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
Output: [null,null,"bar","bar",null,"bar2","bar2"]
*/

import java.util.*;

public class TimeBasedKeyValueStore {
    private Map<String, List<Pair>> map;
    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);
        int left = 0, right = list.size() - 1;
        String res = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                res = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
    private static class Pair {
        int timestamp;
        String value;
        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

/*
Explanation:
We use a HashMap to store for each key a list of (timestamp, value) pairs. For get, we binary search for the largest timestamp <= given timestamp.
*/ 