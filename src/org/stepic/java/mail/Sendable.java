package org.stepic.java.mail;

/**
 * Created by Mikhail Valeyko on 29/10/2015.
 */
public interface Sendable<T> {
    String getFrom();

    String getTo();

    T getContent();
}
