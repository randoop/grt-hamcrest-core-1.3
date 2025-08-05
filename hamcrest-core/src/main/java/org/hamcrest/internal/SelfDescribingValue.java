package org.hamcrest.internal;

import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;

public class SelfDescribingValue<T> implements SelfDescribing {
    private T value;
    
    @SideEffectFree
    public SelfDescribingValue(T value) {
        this.value = value;
    }

    @Impure
    @Override
    public void describeTo(Description description) {
        description.appendValue(value);
    }
}
