package com.test.demo.action.deadlock;

import com.test.demo.action.base.BaseAction;

import java.sql.SQLOutput;

/**
 * Creator weishi8
 * Date&Time 2019-08-08 16:10
 * description
 */
public class DeadLockAction {

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
    

    public static void main(String[] args) {
        DeadLockThread1 deadLockThread1 = new DeadLockThread1();
        Thread t1 = new Thread(deadLockThread1,"");
        DeadLockThread2 deadLockThread2 = new DeadLockThread2();
        Thread t2 = new Thread(deadLockThread2,"");
        t1.start();
        t2.start();
        System.out.println("execute over...");
    }

}
