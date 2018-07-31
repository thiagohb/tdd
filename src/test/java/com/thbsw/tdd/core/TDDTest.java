package com.thbsw.tdd.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import java.util.Iterator;
import java.util.List;
import org.junit.Test;

public class TDDTest {

    @Test
    public void testWhatDoesItMeans() {
        final String meaning = TDD.whatDoesItMeans();

        assertEquals("Test-Driven Development", meaning);
    }

    @Test
    public void testWhatIsIt() {
        final String whatIsIt = TDD.whatIsIt();

        assertEquals("Software development process", whatIsIt);
        assertNotEquals("Test technique", whatIsIt);
    }

    @Test
    public void testGetCycleIterator() {
        final Iterator<TDD.Cycle> iterator = TDD.getCycleIterator();

        final TDD.Cycle firstStep = iterator.next();
        assertEquals(TDD.Cycle.TEST, firstStep);
        assertFalse("Tests should fail.", firstStep.isTestsPassing());

        final TDD.Cycle secondStep = iterator.next();
        assertEquals(TDD.Cycle.CODE, secondStep);
        assertTrue("Tests should pass.", secondStep.isTestsPassing());

        final TDD.Cycle thirdStep = iterator.next();
        assertEquals(TDD.Cycle.REFACTOR, thirdStep);
        assertTrue("Tests should continue pass.", thirdStep.isTestsPassing());

        assertEquals(TDD.Cycle.TEST, iterator.next());
        assertEquals(TDD.Cycle.CODE, iterator.next());
        assertEquals(TDD.Cycle.REFACTOR, iterator.next());
    }

    @Test
    public void testGetLaws() {
        final List<String> laws = TDD.getLaws();

        assertThat(laws.size(), is(3));
        assertThat(laws.get(0), both(containsString("not write production code"))
                .and(containsString("written a failing unit test")));
        assertThat(laws.get(1), both(containsString("not write more of a unit test"))
                .and(containsString("sufficient to fail")));
        assertThat(laws.get(2), both(containsString("not write more production code"))
                .and(containsString("sufficient to pass")));
    }

    @Test
    public void testGetQuote() {
        final String quote = TDD.getQuote();

        assertEquals("TDD is a crazy idea that works.", quote);
    }

}
