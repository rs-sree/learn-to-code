package com.learn.string;

import java.util.Scanner;

/**
 * <p> question from
 * <a href="https://www.hackerrank.com/challenges/reduced-string/problem"></p>
 *
 * <p> sample input : abbcca => steps acca, aa , emptystring
 * sample output: empty string</p>
 * <p> sample input : ababcca ababa
 * sample output: ababa</p>
 */
public class SuperReducedString {

    static String reduceString(final String input) {
        String str = input;
        int len = input.length();
        int i = 0;
        while (i < len - 1) {
            char current = input.charAt(i);
            char next = input.charAt(i + 1);

            if (current == next) {
                str = str.substring(0, i) + str.substring(i + 2);
                len = str.length();
                i = 0;
                continue;
            }
            i++;
        }
        if (input.length() == 0) {
            return "Empty String";
        }
        return input;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println(reduceString(in.nextLine()));
        } finally {
            in.close();
        }

    }
}
