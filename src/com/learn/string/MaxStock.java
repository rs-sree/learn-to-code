package com.learn.string;

import java.util.List;

/**
 *
 */
public class MaxStock {

    public static long stockmax(List<Integer> prices) {
        long profit = 0L;
        int maxSoFar = 0;
        for (int i = prices.size() - 1; i > -1; i--) {
            if (prices.get(i) >= maxSoFar) {
                maxSoFar = prices.get(i);
            }
            profit += maxSoFar - prices.get(i);
        }
        return profit;
    }
}
