package com.demo.action.interview.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Creator weishi8
 * Date&Time 2019-08-21 17:21
 * description 队列实现栈
 * 整体思路：
 *  1、定义两个队列 queue1、queue2，在进行入队、出队过程中，总会是一个为空，另一个非空；
 *  2、queue1用于队列数据压入，在压入前，要保证所有的数据，都在queue1（如果queue2中有数据，需要压入到queue1）；
 *  3、queue2用于队列数据压出：将queue2队列中的所有数据，逐个压出，并压入到queue1，但将queue2中最后一个元素，进行返回；
 */
public class QueueToStack {

    // queue1 用于数据的压入
    private LinkedBlockingQueue<Integer>queue1 = new LinkedBlockingQueue<>();

    // queue2 用于数据的弹出
    private LinkedBlockingQueue<Integer>queue2 = new LinkedBlockingQueue<>();

    /**
     * 数据压入队列
     * @param node
     * @throws InterruptedException
     */
    public void put(int node) throws InterruptedException {

        // 2、queue1用于队列数据压入，在压入前，要保证所有的数据，都在queue1（如果queue2中有数据，需要压入到queue1）；
        while(queue2.size()>0){
            queue1.put(queue2.take());
        }
        // 将新元素，压入到queue1
        queue1.put(node);
        System.out.println("put "+node);
        System.out.println("queue1:"+Arrays.toString(queue1.toArray()));
    }

    /**
     * 数据弹出操作
     * @return
     * @throws InterruptedException
     */
    public int take() throws InterruptedException {
        // 3、queue2用于队列数据压出：将queue2队列中的所有数据，逐个压出，并压入到queue1，但将queue2中最后一个元素，进行返回；
        while(queue1.size()>0){
            int currNode = queue1.take();
            // 为了判断，是否是最后一个元素了
            if(queue1.size()==0){
                System.out.println("take "+currNode);
                System.out.println("queue2:"+Arrays.toString(queue2.toArray()));
                // queue1 中最后一个元素，不需压入到queue2
                return currNode;
            }
            // 将queue1中的各个元素，压入到queue2
            queue2.put(currNode);
        }
        return -1;
    }

    public static void main(String[] args) throws InterruptedException {
        QueueToStack queue1 = new QueueToStack();
        queue1.put(1);
        queue1.put(2);
        queue1.put(3);
        queue1.put(4);
        queue1.take();
        queue1.put(5);
        queue1.put(6);
        queue1.take();
    }
}
