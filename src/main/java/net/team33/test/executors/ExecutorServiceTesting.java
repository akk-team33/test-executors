package net.team33.test.executors;

import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

public class ExecutorServiceTesting {

    private final int maxJobs;
    private final Supplier<ExecutorService> newService;

    public ExecutorServiceTesting(final int maxJobs, final Supplier<ExecutorService> newService) {
        this.maxJobs = maxJobs;
        this.newService = newService;
    }

    /**
     * This test will check out what happens, when worker threads terminate unexpectedly, e.g. caused by an exception.
     * Will there be replacements for those threads or will there be no more threads left at all after some of those
     * cases?
     */
    public final void dyingThreads() {
        final Runnable job = null;
        final ExecutorService subject = newService.get();
        for (int index = 0; index < maxJobs; ++index) {
            subject.execute(job);
        }
    }
}
