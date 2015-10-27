package org.stepic.java;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Mikhail.Valeyko on 27.10.2015.
 */
public class TernaryOperator {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return s -> condition.test(s) ? ifTrue.apply(s) : ifFalse.apply(s);
    }

    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safeStringLength.apply("123"));
        System.out.println(safeStringLength.apply(null));
    }
}
