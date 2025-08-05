package org.hamcrest;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.Impure;

/**
 * TODO(ngd): Document.
 *
 * @param <T>
 */
public abstract class DiagnosingMatcher<T> extends BaseMatcher<T> {

    @Pure
    @Impure
    @Override
    public final boolean matches(Object item) {
        return matches(item, Description.NONE);
    }

    @SideEffectFree
    @Impure
    @Override
    public final void describeMismatch(Object item, Description mismatchDescription) {
        matches(item, mismatchDescription);
    }

    @Pure
    protected abstract boolean matches(Object item, Description mismatchDescription);
}
