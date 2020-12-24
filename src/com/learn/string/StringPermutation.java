package com.learn.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class StringPermutation {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            String str1 = scan.next();
            List<String> arrayList = new ArrayList<>();
            List<String> arrayList2 = new ArrayList<>();
            HashMap<Character, Integer> map = buildFreqMap(str1);
            getPermutation("", str1, arrayList);
            getPermutation(map, "", str1.length(), arrayList2);
            for (String str : arrayList) {
                System.out.println(str);
            }
            System.out.println("Without Duplicates");
            for (String str : arrayList2) {
                System.out.println(str);
            }
        }
    }

    private static HashMap<Character, Integer> buildFreqMap(String str1) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str1.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    private static void getPermutation(String prefix, final String remainder, final List<String> lists) {
        if (remainder.length() == 0) lists.add(prefix);
        int len = remainder.length();
        for (int i = 0; i < len; i++) {
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            char c = remainder.charAt(i);
            getPermutation(prefix + c, before + after, lists);

        }
    }

    private static void getPermutation(HashMap<Character, Integer> map, String prefix, final int remainder, final List<String> lists) {
        if (remainder == 0) {
            lists.add(prefix);
            return;
        }
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                getPermutation(map, prefix + c, remainder - 1, lists);
                map.put(c, count);
            }

        }
    }
}
