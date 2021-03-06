package com.gmail.imshhui.medium;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed.
 * Your design should support the following methods:
 *
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 * Each item in the news feed must be posted by users who the user followed or by the user herself.
 * Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 *
 * Twitter twitter = new Twitter();
 *
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 *
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 *
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 *
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 *
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 *
 * @see <a href="https://leetcode.com/problems/design-twitter/">355. Design Twitter</a>
 * User: liyulin
 * Date: 2019/11/4
 */
public class Twitter {
    private AtomicInteger timeStamp;
    private Map<Integer, List<Tweet>> tweets;
    private Map<Integer, Set<Integer>> follows;

    /** Initialize your data structure here. */
    public Twitter() {
        timeStamp = new AtomicInteger();
        tweets = new HashMap<>();
        follows = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Tweet> list = tweets.getOrDefault(userId, new ArrayList<>());
        list.add(new Tweet(userId, tweetId, timeStamp.incrementAndGet()));
        tweets.put(userId, list);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> userIds = follows.getOrDefault(userId, new HashSet<>());
        userIds.add(userId);
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> queue = new PriorityQueue<>((a, b) -> (b.timeStamp - a.timeStamp));
        for (Integer id : userIds) {
            List<Tweet> userTweets = tweets.getOrDefault(id, new ArrayList<>());
            userTweets.forEach(tweet -> queue.add(tweet));
        }
        while (res.size() < 10 && !queue.isEmpty()) {
            res.add(queue.poll().tweetId);
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set set = follows.getOrDefault(followerId, new HashSet<>());
        set.add(followeeId);
        follows.put(followerId, set);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set set = follows.getOrDefault(followerId, new HashSet<>());
        set.remove(followeeId);
        follows.put(followerId, set);
    }

    private class Tweet {
        private int timeStamp;
        private int userId;
        private int tweetId;

        public Tweet(int userId, int tweetId, int timeStamp) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
