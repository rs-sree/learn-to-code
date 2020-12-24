package com.learn.string;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * The answer is guaranteed to fit in a 32-bit integer.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: s = "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * Example 3:
 * <p>
 * Input: s = "0"
 * Output: 0
 * Explanation: There is no character that is mapped to a number starting with '0'.
 * We cannot ignore a zero when we face it while decoding. So, each '0'
 * should be part of "10" --> 'J' or "20" --> 'T'.
 */
public class DecodeWays {

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[1] = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char p = s.charAt(i - 1);

            if (c == '0' && (p == '0' || p > '2')) {
                return 0;
            }

            if (p == '0') {
                dp[i + 1] = dp[i];
            } else if (p == '1') {
                if (c == '0') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    dp[i + 1] = dp[i - 1] + dp[i];
                }
            } else if (p == '2') {
                if (c == '0') {
                    dp[i + 1] = dp[i - 1];
                } else if (c <= '6') {
                    dp[i + 1] = dp[i] + dp[i - 1];
                } else {
                    dp[i + 1] = dp[i];
                }
            } else {
                dp[i + 1] = dp[i];
            }

        }

        return dp[s.length()];
    }
}
