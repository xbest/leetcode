package com.gmail.imshhui.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
 * and it returns a short URL such as http://tinyurl.com/4e9iAk.
 *
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work.
 * You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 *
 * @see <a href="https://leetcode.com/problems/encode-and-decode-tinyurl/">535. Encode and Decode TinyURL</a>
 * User: liyulin
 * Date: 2020/2/26
 */
public class EncodeAndDecodeTinyURL {
    private static final String host = "http://tinyurl.com/";
    private Map<Integer, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int key = longUrl.hashCode();
        map.put(key, longUrl);
        return host + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int key = Integer.valueOf(shortUrl.replace(host, ""));
        return map.get(key);
    }
}
