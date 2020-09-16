package com.ycit.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author chenxiaolei
 * @date 2019/10/22
 */
public class ThreadPoolExecutorTest {

    @Test
    public void ctlTest() {
        final int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY   = (1 << COUNT_BITS) - 1;
        int RUNNING = (-1) << COUNT_BITS;
        int SHUTDOWN = 0 << COUNT_BITS;
        int STOP       =  1 << COUNT_BITS;
        int TIDYING    =  2 << COUNT_BITS;
        int TERMINATED =  3 << COUNT_BITS;
        int ctlOf = RUNNING | 0;
        int workCount = ctlOf & CAPACITY;
        System.out.println(RUNNING);
    }

    public void exceptionTest() {
    }

    public ThreadPoolExecutor caseVehicleAnalysisThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("case_vehicle_analysis_%s")
                .setUncaughtExceptionHandler(new ThreadUncaughtExceptionHandler())
                .build();
        return new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100),
                threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
    }

    class ThreadUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("t find exception");
        }
    }

}
