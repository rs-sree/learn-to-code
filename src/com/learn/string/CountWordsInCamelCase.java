package com.learn.string;

import java.util.Scanner;

/**
 * <p> question from
 * <a href="https://www.hackerrank.com/challenges/camelcase/problem"></p>
 *
 * <p> sample input : heloSreeHowAreYou
 * sample output: 5</p>
 */
public class CountWordsInCamelCase {

    static int camelcase(String s) {
        String[] words = s.split("[A-Z]");
        return words.length;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println(camelcase(in.nextLine()));
        } finally {
            in.close();
        }

    }
}
