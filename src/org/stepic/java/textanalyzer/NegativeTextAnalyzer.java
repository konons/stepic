package org.stepic.java.textanalyzer;

/**
 * Created by Mikhail.Valeyko on 05.10.2015.
 */
class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    @Override
    protected String[] getKeywords() {
        return new String[0];
    }

    @Override
    protected Label getLabel() {
        return null;
    }

    @Override
    public Label processText(String text) {
        return null;
    }
}
