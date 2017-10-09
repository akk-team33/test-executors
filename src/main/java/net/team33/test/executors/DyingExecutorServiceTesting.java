package net.team33.test.executors;

import java.util.concurrent.Executor;
import java.util.function.Consumer;

public class DyingExecutorServiceTesting<X extends Executor> {

    public final X service;

    public int maxJobs;

    public DyingExecutorServiceTesting(final X service) {
        this.service = service;
    }

    public DyingExecutorServiceTesting<X> prepare(final Consumer<DyingExecutorServiceTesting<X>> consumer) {
        consumer.accept(this);
        return this;
    }

    public DyingExecutorServiceTesting<X> run(final Consumer<DyingExecutorServiceTesting<X>> consumer) {
        consumer.accept(this);
        return this;
    }
}
