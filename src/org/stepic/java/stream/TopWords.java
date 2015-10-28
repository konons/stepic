package org.stepic.java.stream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Mikhail.Valeyko on 28.10.2015.
 */
public class TopWords {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        getTop10Words(reader.lines()).forEach(System.out::println);
    }

    public static Stream<String> getTop10Words(Stream<String> linesStream) {
        Map<String, Long> map = new HashMap<>();
        linesStream.map(line -> line.split("[^a-zA-Zа-яА-Я0-9]+"))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .forEach(word -> map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1L));

        return map.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue() < o2.getValue()) {
                return 1;
            }
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return -1;
        }).limit(10).map(Map.Entry::getKey);
    }
}
