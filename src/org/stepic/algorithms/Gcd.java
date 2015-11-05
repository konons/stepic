package org.stepic.algorithms;

import java.util.Scanner;

/**
 * Created by Mikhail Valeyko on 05/11/2015.
 */
public class Gcd {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long a = s.nextLong(), b = s.nextLong();
        System.out.println(euclid(a, b));
    }

    public static long euclid(long a, long b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a > b ? a : b;
    }
}
