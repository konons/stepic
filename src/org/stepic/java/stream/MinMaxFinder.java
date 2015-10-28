package org.stepic.java.stream;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/**
 * Created by Mikhail.Valeyko on 28.10.2015.
 */
public class MinMaxFinder {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        LinkedList<T> sorted = new LinkedList<>();
        stream.sorted(order).forEach(sorted::add);
        if (sorted.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(sorted.getFirst(), sorted.getLast());
        }
    }
}
