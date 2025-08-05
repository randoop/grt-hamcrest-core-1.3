/*  Copyright (c) 2000-2010 hamcrest.org
 */
package org.hamcrest.core;

import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.Pure;
import static org.hamcrest.core.IsNot.not;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Factory;
import org.hamcrest.BaseMatcher;

/**
 * Is the value null?
 */
public class IsNull<T> extends BaseMatcher<T> {
    @Pure
    @Override
    public boolean matches(Object o) {
        return o == null;
    }

    @Impure
    @Override
    public void describeTo(Description description) {
        description.appendText("null");
    }

    /**
     * Creates a matcher that matches if examined object is <code>null</code>.
     * <p/>
     * For example:
     * <pre>assertThat(cheese, is(nullValue())</pre>
     * 
     */
    @Impure
    @Factory
    public static Matcher<Object> nullValue() {
        return new IsNull<Object>();
    }

    /**
     * A shortcut to the frequently used <code>not(nullValue())</code>.
     * <p/>
     * For example:
     * <pre>assertThat(cheese, is(notNullValue()))</pre>
     * instead of:
     * <pre>assertThat(cheese, is(not(nullValue())))</pre>
     * 
     */
    @Impure
    @Factory
    public static Matcher<Object> notNullValue() {
        return not(nullValue());
    }

    /**
     * Creates a matcher that matches if examined object is <code>null</code>. Accepts a
     * single dummy argument to facilitate type inference.
     * <p/>
     * For example:
     * <pre>assertThat(cheese, is(nullValue(Cheese.class))</pre>
     * 
     * @param type
     *     dummy parameter used to infer the generic type of the returned matcher
     */
    @Impure
    @Factory
    public static <T> Matcher<T> nullValue(Class<T> type) {
        return new IsNull<T>();
    }

    /**
     * A shortcut to the frequently used <code>not(nullValue(X.class)). Accepts a
     * single dummy argument to facilitate type inference.</code>.
     * <p/>
     * For example:
     * <pre>assertThat(cheese, is(notNullValue(X.class)))</pre>
     * instead of:
     * <pre>assertThat(cheese, is(not(nullValue(X.class))))</pre>
     * 
     * @param type
     *     dummy parameter used to infer the generic type of the returned matcher
     *  
     */
    @Impure
    @Factory
    public static <T> Matcher<T> notNullValue(Class<T> type) {
        return not(nullValue(type));
    }
}

