/*
LeetCode 355. Design Twitter

Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.
Implement the Twitter class:
- Twitter() Initializes your twitter object.
- void postTweet(int userId, int tweetId) Composes a new tweet.
- List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
- void follow(int followerId, int followeeId) The user with followerId started following the user with followeeId.
- void unfollow(int followerId, int followeeId) The user with followerId stopped following the user with followeeId.

Example 1:
Input: ["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"], [[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
Output: [null,null,[5],null,null,[6,5],null,[5]]
*/

import java.util.*;

public class DesignTwitter {
    private static int timeStamp = 0;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;
    private class Tweet {
        int id, time;
        Tweet(int id, int time) { this.id = id; this.time = time; }
    }
    public DesignTwitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId, timeStamp++));
    }
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> heap = new PriorityQueue<>((a, b) -> b.time - a.time);
        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if (followMap.containsKey(userId)) users.addAll(followMap.get(userId));
        for (int uid : users) {
            List<Tweet> tweets = tweetMap.getOrDefault(uid, new ArrayList<>());
            for (Tweet t : tweets) heap.offer(t);
        }
        List<Integer> res = new ArrayList<>();
        int n = 0;
        while (!heap.isEmpty() && n++ < 10) res.add(heap.poll().id);
        return res;
    }
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) followMap.get(followerId).remove(followeeId);
    }
}

/*
Explanation:
We use a HashMap for followers and tweets. For news feed, use a max-heap to get the 10 most recent tweets from the user and their followees.
*/ 