/*  Copyright (c) 2000-2006 hamcrest.org
 */
package org.hamcrest.core;

import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.Pure;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;


/**
 * Is the value the same object as another value?
 */
public class IsSame<T> extends BaseMatcher<T> {
    private final T object;
    
    @Impure
    public IsSame(T object) {
        this.object = object;
    }

    @Pure
    @Override
    public boolean matches(Object arg) {
        return arg == object;
    }

    @Impure
    @Override
    public void describeTo(Description description) {
        description.appendText("sameInstance(")
                .appendValue(object)
                .appendText(")");
    }
    
    /**
     * Creates a matcher that matches only when the examined object is the same instance as
     * the specified target object.
     *
     * @param target
     *     the target instance against which others should be assessed
     */
    @Impure
    @Factory
    public static <T> Matcher<T> sameInstance(T target) {
        return new IsSame<T>(target);
    }
    
    /**
     * Creates a matcher that matches only when the examined object is the same instance as
     * the specified target object.
     *
     * @param target
     *     the target instance against which others should be assessed
     */
    @Impure
    @Factory
    public static <T> Matcher<T> theInstance(T target) {
        return new IsSame<T>(target);
    }
}
