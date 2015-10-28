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
//        List<String> topWords = linesHandler(reader.lines());

        List<String> topWords = new ArrayList<>();
        topWords.add("Мама мыла-мыла-мыла раму!");
//        topWords.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.");
        topWords = linesHandler(topWords.stream());

        for (String word : topWords) {
            System.out.println(word);
        }
    }

    public static List<String> linesHandler(Stream<String> stream) {
        Map<String, Long> map = new HashMap<>();
        stream.map(line -> line.split("[^a-zA-Zа-яА-Я0-9]+"))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .forEach(word -> map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1L));
        List<String> list = new LinkedList<>();
        map.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue() < o2.getValue()) {
                return 1;
            }
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return -1;
        }).limit(10).forEach(stringLongEntry -> list.add(stringLongEntry.getKey()));
        return list;
    }
}
