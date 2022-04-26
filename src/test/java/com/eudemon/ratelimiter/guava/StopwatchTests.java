package com.eudemon.ratelimiter.guava;

import com.google.common.base.Stopwatch;
import org.apache.commons.lang3.time.StopWatch;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author william
 * @title
 * @desc
 * @date 2022/4/26
 **/
public class StopwatchTests {

    @Test
    public void testStopwatch() throws InterruptedException {
        Stopwatch watch = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(4);
        System.out.println(watch.elapsed(TimeUnit.MILLISECONDS));
    }
}
