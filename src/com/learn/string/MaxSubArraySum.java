package com.learn.string;

/**
 *
 */
public class MaxSubArraySum {


    static int[] maxSubarray(int[] arr) {
        long maxConSum = Long.MIN_VALUE, maxNonConSum = Long.MIN_VALUE, prevSum = 0;
        int[] out = new int[2];
        for (int x : arr) {
            int currentSum = x;
            if (prevSum > 0) {
                currentSum += prevSum;
            }
            if (currentSum > maxConSum) {
                maxConSum = currentSum;
            }
            prevSum = currentSum;
            if (maxNonConSum < 0 && x > maxNonConSum) {
                maxNonConSum = x;
            } else if (maxNonConSum > 0 && x > 0) {
                maxNonConSum += x;
            }
        }
        out[0] = (int) maxConSum;
        out[1] = (int) maxNonConSum;
        return out;

    }
}
