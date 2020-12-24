package com.learn.string;

/**
 * Find Divisors / Integer Factorization Problem
 * <p>
 * NN is a sum of kk consecutive numbers, i.e. N = (x + 1) + (x + 2) + ... + (x + k)N=(x+1)+(x+2)+...+(x+k).
 * <p>
 * simple
 * <p>
 * Let's regroup the terms N = x k + (1 + 2 + ... + k)N=xk+(1+2+...+k) and use well-known formula for the sum of natural numbers 1 + 2 + ... + k = \frac{k(k + 1)}{2}1+2+...+k=
 * 2
 * k(k+1)
 * ​
 * :
 * <p>
 * N = x k + \frac{k (k + 1)}{2} \qquad (1)N=xk+
 * 2
 * k(k+1)
 * ​
 * (1)
 * <p>
 * 2N = k (2x + k + 1) \qquad (2)2N=k(2x+k+1)(2)
 */
public class ConsecutiveNumber {

// N = (x + 1) + ... + (x + k)
// N = x k + k(k + 1)/2

    public int consecutiveNumbersSum(int N) {
        int count = 0;
        // x > 0 --> N/k - (k + 1)/2 > 0
        int upper_limit = (int) (Math.sqrt(2 * N + 0.25) - 0.5);
        for (int k = 1; k <= upper_limit; ++k) {
            // x should be an integer
            if ((N - k * (k + 1) / 2) % k == 0)
                count++;
        }
        return count;
    }

}
