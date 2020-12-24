package com.learn.string;

/**
 * <a href= "https://www.hackerrank.com/challenges/max-array-sum/problem" /a>
 */
public class MaxArraySubSet {

    static int maxSubsetSum(int[] arr) {
        int sum = arr[0];
        int exc = 0;
        int exc_new;
        for (int i = 1; i < arr.length; i++) {
            exc_new = Math.max(exc, sum);
            sum = exc + arr[i];
            exc = exc_new;
        }
        return Math.max(exc, sum);
    }

}
