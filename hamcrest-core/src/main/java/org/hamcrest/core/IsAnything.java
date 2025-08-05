/*  Copyright (c) 2000-2006 hamcrest.org
 */
package org.hamcrest.core;

import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.Pure;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Factory;
import org.hamcrest.BaseMatcher;


/**
 * A matcher that always returns <code>true</code>.
 */
public class IsAnything<T> extends BaseMatcher<T> {

    private final String message;

    @Impure
    public IsAnything() {
        this("ANYTHING");
    }

    @Impure
    public IsAnything(String message) {
        this.message = message;
    }

    @Pure
    @Override
    public boolean matches(Object o) {
        return true;
    }

    @Impure
    @Override
    public void describeTo(Description description) {
        description.appendText(message);
    }

    /**
     * Creates a matcher that always matches, regardless of the examined object.
     */
    @Impure
    @Factory
    public static Matcher<Object> anything() {
        return new IsAnything<Object>();
    }

    /**
     * Creates a matcher that always matches, regardless of the examined object, but describes
     * itself with the specified {@link String}.
     *
     * @param description
     *     a meaningful {@link String} used when describing itself
     */
    @Impure
    @Factory
    public static Matcher<Object> anything(String description) {
        return new IsAnything<Object>(description);
    }
}
