package com.learn.string;

import java.util.HashSet;

public class Branches {
    public static int count(int[] tree) {

        int n = tree.length;

        final HashSet<Integer> branch = new HashSet<>();

        for (int j : tree) {
            if (j > 0) {
                branch.add(j);
            }
        }
        return branch.size();

    }

    public static void main(String[] args) {
        System.out.println(Branches.count(new int[]{1, 3, 1, -1, 3}));
    }
}