package org.hamcrest.internal;

import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import java.util.Iterator;

import org.hamcrest.SelfDescribing;

public class SelfDescribingValueIterator<T> implements Iterator<SelfDescribing> {
    private Iterator<T> values;
    
    @SideEffectFree
    public SelfDescribingValueIterator(Iterator<T> values) {
        this.values = values;
    }
    
    @Pure
    @Override
    public boolean hasNext() {
        return values.hasNext();
    }

    @Impure
    @Override
    public SelfDescribing next() {
        return new SelfDescribingValue<T>(values.next());
    }

    @Impure
    @Override
    public void remove() {
        values.remove();
    }
}
