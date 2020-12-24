package com.learn.string;


import java.util.Arrays;

public class RemoveRepetitions {
    public static String transform(String input) {
        StringBuffer s = new StringBuffer();
        int n = input.length();
        char[] array = input.toCharArray();
        if (n < 2) {
            return input;
        }
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (array[j] != array[i]) {
                j++;
                array[j] = array[i];
            }
        }
        for (int i = 0; i < j + 1; i++) {
            s.append(array[i]);
        }
        return s.toString();
    }

    static String removeDuplicate(char str[], int n) {
        int index = 0;

        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (str[i] == str[j]) {
                    break;
                }
            }
            if (j == i) {
                str[index++] = str[i];
            }
        }
        return String.valueOf(Arrays.copyOf(str, index));
    }

    public static String uniqueAdj(String s) {
        StringBuilder str = new StringBuilder();
        int len = s.length();
        str.append(s.charAt(0));
        for (int i = 1; i < len - 1; i++) {
            char c = s.charAt(i);
            if (c != str.charAt(str.length() - 1)) {
                str.append(c);
            }
        }
        return str.toString();
    }
    public static String unique(String s) {
        StringBuilder str = new StringBuilder();
        int len = s.length();
        str.append(s.charAt(0));
        for (int i = 1; i < len - 1; i++) {
            char c = s.charAt(i);
            if (str.indexOf(String.valueOf(c)) < 0) {
                str.append(c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {

        System.out.println(RemoveRepetitions.uniqueAdj("abbcbbb"));
        System.out.println(RemoveRepetitions.unique("abbcbbb"));
    }
}