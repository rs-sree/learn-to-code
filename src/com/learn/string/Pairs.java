package com.learn.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://www.hackerrank.com/challenges/pairs/problem />
 */
public class Pairs {

    static List<Integer> pairs(String s, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < startIndices.size(); i++) {
            int start = startIndices.get(i);
            int end = endIndices.get(i);
            String sub = s.substring(start, end);
            char[] c = sub.toCharArray();
            boolean startBar = false;
            Stack<Character> a = new Stack<>();
            int count = 0, mainCount = 0;
            for (int j = 0; j < c.length; j++) {
                if (c[j] == '|') {
                    startBar = true;
                }
                if (startBar && c[j] == '*') {
                    count++;
                } else if (startBar && c[j] == '|' && j != c.length - 1) {
                    mainCount += count;
                    count = 0;
                } else if (startBar && c[j] == '|' && j == c.length - 1) {
                    mainCount += count;
                }
            }
            r.add(mainCount);
        }

        return r;
    }
}
