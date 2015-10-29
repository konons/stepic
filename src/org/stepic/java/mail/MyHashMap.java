package org.stepic.java.mail;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mikhail Valeyko on 29/10/2015.
 */
public class MyHashMap<V> extends HashMap<String, List<V>> {
    @Override
    public List<V> get(Object key) {
        return this.getOrDefault(key, new LinkedList<>());
    }
}
