package com.learn.string;

import java.util.Arrays;

/**
 *
 */
public class TwoStrings {

    static String twoStrings(final String s1, final String s2) {
        boolean v[]=new boolean[26];
        Arrays.fill(v,false);
        for (int i = 0; i < s1.length(); i++)
            v[s1.charAt(i) - 'a'] = true;
        for (int i = 0; i < s2.length(); i++)
            if (v[s2.charAt(i) - 'a'])
                return "YES";

        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(twoStrings("ab", "a"));
    }
}
