package com.jnape.palatable.lambda.functions.builtin.fn1;

import com.jnape.palatable.lambda.functions.Fn1;
import com.jnape.palatable.lambda.iterators.ReversingIterator;

/**
 * Given an <code>Iterable</code>, return a reversed representation of that <code>Iterable</code>. Note that reversing
 * is deferred until the returned <code>Iterable</code> is iterated.
 *
 * @param <A> The Iterable element type
 */
public final class Reverse<A> implements Fn1<Iterable<A>, Iterable<A>> {

    private static final Reverse INSTANCE = new Reverse();

    private Reverse() {
    }

    @Override
    public Iterable<A> apply(Iterable<A> as) {
        return () -> new ReversingIterator<>(as.iterator());
    }

    @SuppressWarnings("unchecked")
    public static <A> Reverse<A> reverse() {
        return INSTANCE;
    }

    public static <A> Iterable<A> reverse(Iterable<A> as) {
        return Reverse.<A>reverse().apply(as);
    }
}
