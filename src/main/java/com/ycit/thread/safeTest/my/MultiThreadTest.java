package com.ycit.thread.safeTest.my;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenxiaolei
 * @date 2020/8/20
 */
public class MultiThreadTest {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
//        for (int i=0;i < 1000000;i++) {
        Buss buss = new Buss();
        PageThread2 pageThread = new PageThread2(buss, "A123", "A123");
        PageThread2 pageThread2 = new PageThread2(buss, "B123", "B123");
        PageThread2 pageThread3 = new PageThread2(buss, "C123", "C123");
        PageThread2 pageThread4 = new PageThread2(buss, "D123", "D123");
//        PageThread2 pageThread = new PageThread2(buss, "张三", "张三");
//        PageThread2 pageThread2 = new PageThread2(buss, "李四", "李四");
//        PageThread2 pageThread3 = new PageThread2(buss, "王五", "王五");
//        PageThread2 pageThread4 = new PageThread2(buss, "李6", "李6");
//        executorService.execute(pageThread);
//        executorService.execute(pageThread2);
//        executorService.execute(pageThread3);
        pageThread.start();
        pageThread2.start();
        pageThread3.start();
        pageThread4.start();
//        }
        System.out.println("finish");
//        executorService.shutdown();
    }

    static class PageThread extends Thread {

        private String name;

        private String passport;

        private String name2;

        private String passport2;

        PageThread(String name, String passport) {
            this.name = name;
            this.passport = passport;
        }

        @Override
        public void run() {
            while (true) {
                pass(name, passport);
            }

        }

        public void pass(String name, String passport) {
            this.passport2 = passport;
            this.name2 = name;
            check(name2, passport2);
        }

        public void check(String name , String passport) {
            if (!name.equals(passport)) {
                throw new RuntimeException("name " + name + " passport " + passport + "  不匹配");
            } else {
//                    System.out.println("success");
            }
        }
    }

}
