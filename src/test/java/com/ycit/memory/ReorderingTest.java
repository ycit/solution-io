package com.ycit.memory;

import com.ycit.bean.Student;
import org.junit.Test;

import java.time.LocalDate;

/**
 * 重排序
 * <p>
 * Created by xlch at 2018/6/25
 */
public class ReorderingTest {
    volatile int[]  arr = new int[2];

    @Test
    public void reorderingExample() {
        Student student = new Student("小明", LocalDate.now());
        Student s2 = student;
        s2.setName("小红");
        System.out.println(student.getName());
    }

    @Test
    public void visibleTest() {
        new Thread(()-> {
            LoopMayNeverEnd t = new LoopMayNeverEnd();
            t.work();
        }).start();
        new Thread(() -> {
            LoopMayNeverEnd t = new LoopMayNeverEnd();
            t.stopWork();
        });
    }

    class LoopMayNeverEnd {
        volatile boolean done = false;

        void work() {
            while (!done) {
                // do work
                System.out.println("do--------------");
            }
        }

        void stopWork() {
            done = true;
        }
    }

    @Test
    public void happensBeforeTest() {

        arr[0] = 4;
        arr[1] = 5;
        new Thread(()->{
//            try {
//                Thread.sleep(9000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("t1  arr[0]" + arr[0]);
            if (arr[0] == 6) {
                System.out.println(arr[1]);
            }
        }).start();
        new Thread(()->{
            arr[0] = 6;
            System.out.println(arr[0]);
        }).start();
    }


    }
