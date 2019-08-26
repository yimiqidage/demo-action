package com.demo.action.interview.stack;

import java.util.Stack;

/**
 * Creator weishi8
 * Date&Time 2019-08-21 16:42
 * description 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 整体逻辑
 *  1、stack1用于数据入队，stack2用于数据出队；
 *  2、每次在进行数据出队时，需要保证stack1为空，否则说明stack1中的数据，是最先插入的数据，还没有导入到stack2；
 *  3、每次数据出队列后，需要将stack2中的所有数据，再导入到stack1中，这样才能保证再有数据入队，是在栈的尾部；之后在调用出队方法时，就会继续执行步骤2。
 *
 * 实现思路：
 *  1、定义两个Stack对象，分别为stack1、stack2，类型为Integer；
 *  2、stack1用于队列中数据的压入；stack2用于队列中数据的压出；
 *  3、定义两个方法：push()方法用于入队列；pop()方法用于出队列；
 *  4、push()方法，用于stack1的入栈，直接调用stack1的push方法即可；
 *  5、pop()方法，用于将stack2中的数据压出，需要进行3步动作：
 *      5.1 判断stack1中的数据，是否为空，如果不为空，全部压出，转入到stack2中；
 *      5.2 调用stack2的pop方法，压出栈顶的数据，并暂时进行存储（int result = stack2.pop();）
 *      5.3 判断stack2中的数据，是否为空，如果不为空，全部压出，转入到stack1中；
 */
public class StackToQueue {

    // 1、定义两个Stack对象
    // stack1 做为入数据的栈
    Stack<Integer>stack1 = new Stack<>();
    // stack2 做为出数据的栈
    Stack<Integer>stack2 = new Stack<>();

    /**
     * push方法，用于入队列
     * @param i
     */
    public void push(int i){
        // 2、stack1用于实现队列数据的插入
        stack1.push(i);
        System.out.println("stack1 push "+i+",now stack1 is "+stack1);
    }

    /**
     * pop方法，用于出队列
     * @return
     */
    public int pop(){
        // 5.1 判断stack1中的数据，是否为空，如果不为空，全部压出，转入到stack2中；
        while(!stack1.empty()){
            int node = stack1.pop();
            stack2.push(node);
        }
        // 5.2 调用stack2的pop方法，压出栈顶的数据，并暂时进行存储
        int result = stack2.pop();
        // 5.3 判断stack2中的数据，是否为空，如果不为空，全部压出，转入到stack1中；
        while(!stack2.isEmpty()){
            int node = stack2.pop();
            stack1.push(node);
        }
        System.out.println("pop stack2 "+result+",now stack1 is "+stack1);
        return result;
    }

    public static void main(String[] args) {
        StackToQueue stacksToQueue = new StackToQueue();
        stacksToQueue.push(1);
        stacksToQueue.push(2);
        stacksToQueue.push(3);
        stacksToQueue.push(4);
        stacksToQueue.pop();
        stacksToQueue.push(5);
        stacksToQueue.push(6);
        stacksToQueue.pop();
        stacksToQueue.pop();
        stacksToQueue.push(7);
    }
}
