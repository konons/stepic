package org.stepic.java.textanalyzer;

/**
 * Created by Mikhail.Valeyko on 05.10.2015.
 */
abstract class KeywordAnalyzer {
    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    public void processText() {

    }
}
