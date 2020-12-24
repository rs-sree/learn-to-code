package com.learn.string;//package com.learn.string;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//import java.util.stream.Collectors;
//
//interface OnlineAccount {
//    int basePrice = 120;
//    int regularMoviePrice = 45;
//    int exclusiveMoviePrice = 80;
//}
//
//class Account implements OnlineAccount, Comparable<Account> {
//
//    int noOfRegularMovies, noOfExclusiveMovies;
//    String ownerName;
//
//    // 1) Add a parameterized constructor that initializes the attributes noOfRegularMovies and noOfExclusiveMovies.
//    public Account(final String ownerName, final int numberOfRegularMovies, final int numberOfExclusiveMovies) {
//        this.ownerName = ownerName;
//        this.noOfExclusiveMovies = numberOfExclusiveMovies;
//        this.noOfRegularMovies = numberOfRegularMovies;
//
//    }
//
//
//    // 2. This method returns the monthly cost for the account.
//    public int monthlyCost() {
//        return (basePrice + (noOfRegularMovies * regularMoviePrice) + (noOfExclusiveMovies * exclusiveMoviePrice));
//    }
//
//    // 3. Override the compareTo method of the Comparable interface such that two accounts can be compared based on their monthly cost.
//
//    @Override
//    public String toString() {
//        return "Account{" +
//                "ownerName='" + ownerName + '\'' +
//                ", monthlyCost=" + monthlyCost() +
//                '}';
//    }
//
//    // 4. Returns "Owner is [ownerName] and monthly cost is [monthlyCost] USD."
//
//
//    @Override
//    public int compareTo(Account o) {
//        if (o.monthlyCost() > this.monthlyCost()) {
//            return 1;
//        } else if (o.monthlyCost() == this.monthlyCost()) {
//            return 0;
//        } else {
//            return -1;
//        }
//    }
//}
//
//public class Solution {
//    public static void main(String args[]) throws Exception {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//
//        Scanner sc = new Scanner(System.in);
//        String sub = sc.nextLine();
//
//        int t = Integer.parseInt(sub);
//
//        ArrayList<Account> list = new ArrayList<Account>();
//
//        for (int i = 0; i < t; i++) {
//            String[] input = sc.nextLine().split(" ");
//            list.add(new Account(input[0],
//                    Integer.parseInt(input[1]),
//                    Integer.parseInt(input[2])));
//        }
//
//        Collections.sort(list);
//
//        java.util.List<Integer> a = new ArrayList<>();
//        a.stream()
//                .collect(Collectors.toList()).
//
//                System.out.println("Most valuable account details:");
//        System.out.println(list.get(list.size() - 1));
//    }
//}
//
///**
// * SELECT
// * category,
// * CASE
// * WHEN category = 'customer' THEN c.id
// * WHEN category = 'product' THEN p.id
// * END AS 'id',
// * CASE
// * WHEN category = 'customer' THEN c.customer_name
// * WHEN category = 'product' THEN p.product_name
// * END AS 'name'
// * FROM
// * (
// * SELECT
// * CASE
// * WHEN c.id = c.id THEN 'customer'
// * WHEN p.id = p.id THEN 'product'
// * END as 'category'
// * FROM
// * customer as c
// * LEFT Join -- Left join to show all customers even those with & without invoices
// * invoice as i
// * ON c.id = i.customer_id
// * AND i.id IS NULL -- Gives me all customers who do not have an invoice
// * JOIN invoice_item as ii
// * ON i.id = ii.invoice_id
// * Join product p
// * ON p.id = ii.product_id
// * ) tb1
// * <p>
// * UNION ALL
// * <p>
// * SELECT
// * category,
// * CASE
// * WHEN category = 'customer' THEN c.id
// * WHEN category = 'product' THEN p.id
// * END AS 'id',
// * CASE
// * WHEN category = 'customer' THEN c.customer_name
// * WHEN category = 'product' THEN p.product_name
// * END AS 'name'
// * FROM
// * (
// * SELECT
// * CASE
// * WHEN c.id = c.id THEN 'customer'
// * WHEN p.id = p.id THEN 'product'
// * END as 'category'
// * FROM
// * product as p
// * LEFT JOIN -- Left join to show all products even those that sold and not sold
// * invoice_item as ii
// * ON p.id = ii.product_id
// * AND ii.invoice_id IS NULL -- Gives me products that didnt sell
// * JOIN invoice as i
// * ON ii.invoice_id = i.id
// * ) tb2
// */
////

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int[] arrival = {1, 3, 3, 5, 7};
        int[] duration = {2, 2, 1, 2, 1};
        int[][] events = new int[arrival.length][2];
        for (int i = 0; i < arrival.length; i++) {
            events[i] = new int[]{arrival[i], arrival[i] + duration[i]};
        }
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] first = events[0];
        for (int i = 1; i < events.length; i++) {
            int[] cur = events[i];
            if (cur[0] < first[1])
                minHeap.offer(cur);
            else {
                first[1] = events[i][1];
            }
        }
        System.out.println(arrival.length - minHeap.size());
    }
}
