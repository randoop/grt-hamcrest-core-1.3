package org.hamcrest.internal;

import org.checkerframework.dataflow.qual.SideEffectFree;
import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.Pure;
import java.lang.reflect.Array;
import java.util.Iterator;

public class ArrayIterator implements Iterator<Object> {
    private final Object array;
    private int currentIndex = 0;
    
    @SideEffectFree
    public ArrayIterator(Object array) {
        if (!array.getClass().isArray()) {
            throw new IllegalArgumentException("not an array");
        }
        this.array = array;
    }
    
    @Pure
    @Override
    public boolean hasNext() {
        return currentIndex < Array.getLength(array);
    }

    @Impure
    @Override
    public Object next() {
        return Array.get(array, currentIndex++);
    }
    
    @SideEffectFree
    @Override
    public void remove() {
        throw new UnsupportedOperationException("cannot remove items from an array");
    }
}
