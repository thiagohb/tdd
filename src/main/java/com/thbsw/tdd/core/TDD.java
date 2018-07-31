package com.thbsw.tdd.core;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.iterators.LoopingIterator;

public class TDD {

    enum Cycle {

        TEST    ("Write a test for the next bit of functionality you want to add.", false),
        CODE    ("Write the functional code until the test passes."               , true),
        REFACTOR("Refactor both new and old code to make it well structured."     , true);

        private final String action;
        private final boolean testsPassing;

        Cycle(final String action, final boolean testsPass) {
            this.action = action;
            this.testsPassing = testsPass;
        }

        public String getAction() {
            return action;
        }

        public boolean isTestsPassing() {
            return testsPassing;
        }
    }

    /**
     * Returns the meaning of TDD.
     * @return what TDD means.
     */
    public static String whatDoesItMeans() {
        return "Test-Driven Development";
    }

    /**
     * Returns what TDD is.
     * @return what TDD is.
     */
    public static String whatIsIt() {
        return "Software development process";
    }

    /**
     * Returns the TDD cycle iterator.
     * @return TDD cycle iterator.
     */
    public static Iterator<Cycle> getCycleIterator() {
        final Collection<Cycle> cycle = Arrays.asList(Cycle.TEST, Cycle.CODE, Cycle.REFACTOR);
        return new LoopingIterator<Cycle>(cycle);
    }

    /**
     * Returns the three TDD laws that TDD practice promotes.
     * @return The three important laws.
     */
    public static List<String> getLaws() {
        return Arrays.asList(
                "You may not write production code until you have written a failing unit test.",
                "You may not write more of a unit test than is sufficient to fail, and not compiling is failing.",
                "You may not write more production code than is sufficient to pass the currently failing test.");
    }

    /**
     * Returns the TDD quote created by Kent Beck.
     * @return The TDD quote.
     */
    public static String getQuote() {
        return "TDD is a crazy idea that works.";
    }

}
