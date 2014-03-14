package com.jnape.palatable.lambda.functions;

import com.jnape.palatable.lambda.tuples.Tuple2;

import static com.jnape.palatable.lambda.functions.builtin.dyadic.Partial2.partial2;

public abstract class DyadicFunction<A, B, C> extends MonadicFunction<Tuple2<A, B>, C> {

    @Override
    public final C apply(Tuple2<A, B> args) {
        return apply(args._1, args._2);
    }

    public abstract C apply(A a, B b);

    public final MonadicFunction<B, C> partial(final A a) {
        return partial2(this, a);
    }

    public DyadicFunction<B, A, C> flip() {
        return new DyadicFunction<B, A, C>() {
            @Override
            public C apply(B b, A a) {
                return DyadicFunction.this.apply(a, b);
            }
        };
    }
}
