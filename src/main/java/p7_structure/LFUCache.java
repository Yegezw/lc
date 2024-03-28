package p7_structure;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * <a href="https://leetcode.cn/problems/lfu-cache/description/">460. LFU 缓存</a>
 */
@SuppressWarnings("all")
public class LFUCache {

    private final HashMap<Integer, Integer> data; // key : value
    private final HashMap<Integer, Integer> freq; // key : freq
    private final HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    private int minFreq;
    private final int capacity;

    public LFUCache(int capacity) {
        data = new HashMap<>();
        freq = new HashMap<>();
        freqToKeys = new HashMap<>();

        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!data.containsKey(key)) return -1;
        increaseFreq(key);
        return data.get(key);
    }

    public void put(int key, int value) {
        if (data.containsKey(key)) {
            data.put(key, value);
            increaseFreq(key);
        } else {
            if (data.size() == capacity) removeMinFreqKey();

            data.put(key, value);
            freq.put(key, 1);
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
            minFreq = 1;  // 核心
        }
    }

    // 可能会导致 minFreq++
    private void increaseFreq(int key) {
        int oldFreq = freq.get(key);
        freq.put(key, oldFreq + 1);

        LinkedHashSet<Integer> keys = freqToKeys.get(oldFreq);
        keys.remove(key);
        if (keys.isEmpty()) {
            freqToKeys.remove(oldFreq);
            if (oldFreq == minFreq) minFreq++; // 核心
        }

        freqToKeys.putIfAbsent(oldFreq + 1, new LinkedHashSet<>());
        freqToKeys.get(oldFreq + 1).add(key);
    }

    // 不维护 minFreq, 由 put() 维护
    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);
        int delKey = keys.iterator().next();

        keys.remove(delKey);
        if (keys.isEmpty()) freqToKeys.remove(minFreq);

        data.remove(delKey);
        freq.remove(delKey);
    }
}
