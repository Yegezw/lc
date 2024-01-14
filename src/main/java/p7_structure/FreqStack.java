package p7_structure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/maximum-frequency-stack/description/">895. 最大频率栈</a>
 */
@SuppressWarnings("all")
public class FreqStack {

    private int maxFreq;
    private final HashMap<Integer, Integer> valToFreq;
    private final HashMap<Integer, Deque<Integer>> freqToVals;

    public FreqStack() {
        valToFreq = new HashMap<>();
        freqToVals = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val, freq);

        freqToVals.putIfAbsent(freq, new ArrayDeque<>());
        freqToVals.get(freq).addLast(val);

        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        Deque<Integer> stack = freqToVals.get(maxFreq);
        int val = stack.removeLast();

        int freq = valToFreq.get(val) - 1;
        valToFreq.put(val, freq);

        if (stack.isEmpty()) maxFreq--;
        return val;
    }
}
