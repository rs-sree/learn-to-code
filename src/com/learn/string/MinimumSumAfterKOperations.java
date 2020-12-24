package com.learn.string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * arr= 2, 4
 * step 1=  max element 4, so pick 4 then do 4 / 2 = 2,  final array arr= 2, 2
 * step 2 = max element 2, so pick 2 then do 2/ 2 = 1, final arr = 2,1
 * sum = 3;
 */
public class MinimumSumAfterKOperations {

    static long getMinSumOfArray(List<Integer> num, int k) {
        TreeMap<Integer, Long> map = num.stream().collect(Collectors.groupingBy(
                Function.identity(), TreeMap::new, Collectors.counting()));
        for (int remain = k, applyCount; remain > 0; remain -= applyCount) {
            Map.Entry<Integer, Long> maxEntry = map.lastEntry();
            if ((applyCount = Math.min(maxEntry.getValue().intValue(), remain)) == maxEntry.getValue())
                map.remove(maxEntry.getKey());
            else
                map.put(maxEntry.getKey(), maxEntry.getValue() - applyCount);
            map.merge((maxEntry.getKey() + 1) % 2, (long) applyCount, Long::sum);
        }
        //System.out.println(map.entrySet().stream().map(e -> e.getValue() == 1 ? e.getKey().toString() : e.getKey() + "×" + e.getValue()).collect(Collectors.joining(" + ")));
        return map.entrySet().stream().mapToLong(e -> e.getKey() * e.getValue()).sum();
    }

    static int getMinSumOfArray(final double[] arr, int k) {
        int sum = 0;
        int length = arr.length;
        while (k > 0) {
            Arrays.sort(arr);
            double max = arr[length - 1];
            max = max % 2;
            arr[length - 1] = Math.ceil(max);
            k--;
        }
        for (double value : arr) {
            sum += value;
        }
        return sum;
    }

    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : A) pq.add(i);
        for (int i = 0; i < K; i++) pq.add(-pq.poll());
        int size = pq.size(), sum = 0;
        for (int i = 0; i < size; i++) sum += pq.poll();
        return sum;
    }

    static int getMaxSumOfArray(final double[] arr, int k) {
        int sum = 0;
        int length = arr.length;
        while (k > 0) {
            Arrays.sort(arr);
            double max = arr[0];
            max = max % 2;
            arr[length - 1] = Math.ceil(max);
            k--;
        }
        for (double value : arr) {
            sum += value;
        }
        return sum;
    }


    public static void main(String[] args) {
        double[] arr = {3, 7};
        // System.out.println(getMinSumOfArray(arr, 2));
        System.out.println(getMinSumOfArray(Arrays.asList(3, 7), 2));
    }
}
