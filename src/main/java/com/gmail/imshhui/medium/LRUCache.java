package com.gmail.imshhui.medium;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU)  cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache(2);
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 * @see <a href="https://leetcode.com/problems/lru-cache/"></a>
 * User: liyulin
 * Date: 2019/9/17
 */
public class LRUCache {
    private Map<Integer, Integer> map = new LinkedHashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = -1;
        if (map.containsKey(key)) {
            value = map.get(key);
            map.remove(key);
            map.put(key, value);
        }
        return value;
    }

    public void put(int key, int value) {
        // 需要判断map中是否包含key，如果已经包含key的话直接更新就好，不会超出容量
        // put也算活跃度
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() >= capacity) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }
}
