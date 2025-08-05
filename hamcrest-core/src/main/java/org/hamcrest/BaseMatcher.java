/*  Copyright (c) 2000-2006 hamcrest.org
 */
package org.hamcrest;
import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.SideEffectFree;

/**
 * BaseClass for all Matcher implementations.
 *
 * @see Matcher
 */
public abstract class BaseMatcher<T> implements Matcher<T> {

    /**
     * @see Matcher#_dont_implement_Matcher___instead_extend_BaseMatcher_()
     */
    @SideEffectFree
    @Override
    @Deprecated
    public final void _dont_implement_Matcher___instead_extend_BaseMatcher_() {
        // See Matcher interface for an explanation of this method.
    }

    @Impure
    @Override
    public void describeMismatch(Object item, Description description) {
        description.appendText("was ").appendValue(item);
    }

    @Impure
    @Override
    public String toString() {
        return StringDescription.toString(this);
    }
}
