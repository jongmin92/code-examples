package com.jongmin.ex;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

/**
 * This test class contains only test cases that fail.
 */
public class AssertThatTest {

    @Test
    public void assertThat_default() {
        final String expected = "expected";
        final String actual = "actual";

//        assertEquals(expected, actual);
        assertThat(actual, is(expected));
    }

    @Test
    public void assertThat_errorMessage() {
        final String expected = "expected";
        final String actual = "actual";

//        assertTrue(expected.contains(actual));
        assertThat(actual, containsString(expected));
    }

    @Test
    public void assertThat_typeChecking() {
//        assertEquals("abc", 123);
        assertThat(123, is("abc"));
    }

    @Test
    public void assertThat_flexibility() {
        assertThat("test", allOf(containsString("te"), is("test2")));
    }

    @Test
    public void assertThat_customMatcher() {
        final String expected = "expected";
        final String actual = "actual";

        final CustomMatcher customMatcher = new CustomMatcher(expected);

        assertThat(actual, is(customMatcher));
    }

    public static class CustomMatcher extends TypeSafeMatcher<String> {
        private final String expected;

        public CustomMatcher(String expected) {
            this.expected = expected;
        }

        @Override
        protected boolean matchesSafely(String item) {
            return expected.equals(item);
        }

        @Override
        public void describeTo(Description description) {
            description.appendValue(expected);
        }
    }
}
