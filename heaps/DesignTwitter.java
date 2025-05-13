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

    public static void main(String[] args) {
        // Test case 1: Basic operations
        System.out.println("Test case 1:");
        DesignTwitter twitter1 = new DesignTwitter();
        twitter1.postTweet(1, 5);
        System.out.println("User 1's news feed: " + twitter1.getNewsFeed(1)); // Expected: [5]
        twitter1.follow(1, 2);
        twitter1.postTweet(2, 6);
        System.out.println("User 1's news feed after following user 2: " + twitter1.getNewsFeed(1)); // Expected: [6, 5]
        twitter1.unfollow(1, 2);
        System.out.println("User 1's news feed after unfollowing user 2: " + twitter1.getNewsFeed(1)); // Expected: [5]
        
        // Test case 2: Multiple tweets
        System.out.println("\nTest case 2:");
        DesignTwitter twitter2 = new DesignTwitter();
        twitter2.postTweet(1, 1);
        twitter2.postTweet(1, 2);
        twitter2.postTweet(1, 3);
        System.out.println("User 1's news feed: " + twitter2.getNewsFeed(1)); // Expected: [3, 2, 1]
        
        // Test case 3: Multiple users
        System.out.println("\nTest case 3:");
        DesignTwitter twitter3 = new DesignTwitter();
        twitter3.postTweet(1, 1);
        twitter3.postTweet(2, 2);
        twitter3.postTweet(3, 3);
        twitter3.follow(1, 2);
        twitter3.follow(1, 3);
        System.out.println("User 1's news feed: " + twitter3.getNewsFeed(1)); // Expected: [3, 2, 1]
        
        // Test case 4: Self-following
        System.out.println("\nTest case 4:");
        DesignTwitter twitter4 = new DesignTwitter();
        twitter4.follow(1, 1);
        twitter4.postTweet(1, 1);
        System.out.println("User 1's news feed: " + twitter4.getNewsFeed(1)); // Expected: [1]
        
        // Test case 5: More than 10 tweets
        System.out.println("\nTest case 5:");
        DesignTwitter twitter5 = new DesignTwitter();
        for (int i = 1; i <= 15; i++) {
            twitter5.postTweet(1, i);
        }
        System.out.println("User 1's news feed: " + twitter5.getNewsFeed(1)); // Expected: [15, 14, 13, 12, 11, 10, 9, 8, 7, 6]
    }
}

/*
Explanation:
We use a HashMap for followers and tweets. For news feed, use a max-heap to get the 10 most recent tweets from the user and their followees.
*/ 