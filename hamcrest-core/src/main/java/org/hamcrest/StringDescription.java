package org.hamcrest;

import org.checkerframework.dataflow.qual.SideEffectFree;
import org.checkerframework.dataflow.qual.Impure;
import java.io.IOException;

/**
 * A {@link Description} that is stored as a string.
 */
public class StringDescription extends BaseDescription {
    private final Appendable out;

    @Impure
    public StringDescription() {
        this(new StringBuilder());
    }

    @Impure
    public StringDescription(Appendable out) {
        this.out = out;
    }
    
    /**
     * Return the description of a {@link SelfDescribing} object as a String.
     * 
     * @param selfDescribing
     *   The object to be described.
     * @return
     *   The description of the object.
     */
    @Impure
    public static String toString(SelfDescribing selfDescribing) {
        return new StringDescription().appendDescriptionOf(selfDescribing).toString();
    }

    /**
     * Alias for {@link #toString(SelfDescribing)}.
     */
    @Impure
    public static String asString(SelfDescribing selfDescribing) {
        return toString(selfDescribing);
    }

    @Impure
    @Override
    protected void append(String str) {
        try {
            out.append(str);
        } catch (IOException e) {
            throw new RuntimeException("Could not write description", e);
        }
    }

    @Impure
    @Override
    protected void append(char c) {
        try {
            out.append(c);
        } catch (IOException e) {
            throw new RuntimeException("Could not write description", e);
        }
    }
    
    /**
     * Returns the description as a string.
     */
    @SideEffectFree
    @Override
    public String toString() {
        return out.toString();
    }
}
