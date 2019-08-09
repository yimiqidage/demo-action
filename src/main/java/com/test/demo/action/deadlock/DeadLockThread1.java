package com.test.demo.action.deadlock;

/**
 * Creator weishi8
 * Date&Time 2019-08-08 16:27
 * description
 */
public class DeadLockThread1 implements Runnable{

    @Override
    public void run() {
        synchronized (DeadLockAction.lock1){
            while (true){
                System.out.println("I am waiting lock2...");
                synchronized (DeadLockAction.lock2){
                    System.out.println("I got lock2...");
                }
            }
        }
    }
}
