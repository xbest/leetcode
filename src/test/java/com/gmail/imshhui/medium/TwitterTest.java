package com.gmail.imshhui.medium;

import org.junit.Test;

/**
 * User: liyulin
 * Date: 2019/11/4
 */
public class TwitterTest {
    Twitter client = new Twitter();

    @Test
    public void twitterTest() {
        client.postTweet(1, 5);
        client.getNewsFeed(1);
        client.follow(1, 2);
        client.postTweet(2, 6);
        client.getNewsFeed(1);
        client.unfollow(1, 2);
        client.getNewsFeed(1);
    }
}
