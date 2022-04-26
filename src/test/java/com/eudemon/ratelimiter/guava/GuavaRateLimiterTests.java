package com.eudemon.ratelimiter.guava;

import com.google.common.util.concurrent.RateLimiter;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author william
 * @title
 * @desc
 * @date 2022/4/26
 **/
public class GuavaRateLimiterTests {

    @Test
    public void testSmoothBursty() throws InterruptedException {
        // QPS: 2 1s发放2个令牌
        RateLimiter rateLimiter = RateLimiter.create(1);
        while (true) {
            System.out.println(" costs " + rateLimiter.acquire(2) + "s");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(" costs " + rateLimiter.acquire(2) + "s");
            System.out.println(" costs " + rateLimiter.acquire(2) + "s");
            System.out.println(" costs " + rateLimiter.acquire(2) + "s");
            System.out.println("end");
        }
    }

    @Test
    public void testSmoothwarmingUp() {
        RateLimiter r = RateLimiter.create(2, 3, TimeUnit.SECONDS);
        while (true) {
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("end");
            /**
             * output:
             * get 1 tokens: 0.0s
             * get 1 tokens: 1.329289s
             * get 1 tokens: 0.994375s
             * get 1 tokens: 0.662888s  上边三次获取的时间相加正好为3秒
             * end
             * get 1 tokens: 0.49764s  正常速率0.5秒一个令牌
             * get 1 tokens: 0.497828s
             * get 1 tokens: 0.49449s
             * get 1 tokens: 0.497522s
             */
        }
    }


}
