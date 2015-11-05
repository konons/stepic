package org.stepic.algorithms;

import java.util.Scanner;

/**
 * Created by Mikhail Valeyko on 04/11/2015.
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        System.out.println(lastDigit(n));
    }

    public static long fib(int n, long prev, long next) {
        if (n == 0) {
            return prev;
        } else {
            return fib(n - 1, next, prev + next);
        }
    }

    public static int lastDigit(int n) {
        if (n == 0) {
            return 0;
        }
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int x = b;
            b = (a + b) % 10;
            a = x;
        }
        return b;
    }
}
