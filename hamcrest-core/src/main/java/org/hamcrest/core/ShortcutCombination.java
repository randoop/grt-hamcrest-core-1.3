package org.hamcrest.core;

import org.checkerframework.dataflow.qual.Impure;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

abstract class ShortcutCombination<T> extends BaseMatcher<T> {

    private final Iterable<Matcher<? super T>> matchers;

    @Impure
    public ShortcutCombination(Iterable<Matcher<? super T>> matchers) {
        this.matchers = matchers;
    }
    
    @Impure
    @Override
    public abstract boolean matches(Object o);
    
    @Impure
    @Override
    public abstract void describeTo(Description description);
    
    @Impure
    protected boolean matches(Object o, boolean shortcut) {
        for (Matcher<? super T> matcher : matchers) {
            if (matcher.matches(o) == shortcut) {
                return shortcut;
            }
        }
        return !shortcut;
    }
    
    @Impure
    public void describeTo(Description description, String operator) {
        description.appendList("(", " " + operator + " ", ")", matchers);
    }
}
