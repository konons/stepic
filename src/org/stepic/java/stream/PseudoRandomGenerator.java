package org.stepic.java.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Mikhail.Valeyko on 28.10.2015.
 */
public class PseudoRandomGenerator {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> x * x / 10 % 1000);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pseudoRandomStream(13).limit(20).toArray()));
    }
}
