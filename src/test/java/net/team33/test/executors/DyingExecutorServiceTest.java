package net.team33.test.executors;

import org.junit.Assert;
import org.junit.Test;

public class DyingExecutorServiceTest {

    @Test
    public void dyingThreads() {
        new DyingExecutorServiceTesting<>(new DyingExecutorService())
                .prepare(testing -> testing.maxJobs = 1000)
                .run(testing -> {
                    Assert.assertEquals(0, testing.service.threadCount.get());
                });
    }
}