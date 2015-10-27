package org.stepic.java;

import java.io.*;
import java.util.*;

/**
 * Created by Mikhail.Valeyko on 27.10.2015.
 */
public class Collections {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set = new HashSet<>();
        Set<T> copyOfSet2 = new HashSet<>(set2);
        for (T t : set1) {
            if (copyOfSet2.contains(t)) {
                copyOfSet2.remove(t);
            } else {
                set.add(t);
            }
        }
        set.addAll(copyOfSet2);
        return java.util.Collections.unmodifiableSet(set);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        Integer[] ints = new Integer[list.size()];
        list.toArray(ints);
        int start = ints.length % 2 == 0 ? 1 : 2;
        for (int i = ints.length - start; i >= 0; i -= 2) {
            System.out.printf("%d ", ints[i]);
        }
    }
}
