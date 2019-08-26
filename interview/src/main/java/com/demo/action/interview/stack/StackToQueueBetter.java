package com.demo.action.interview.stack;

import java.util.Stack;

/**
 * Creator weishi8
 * Date&Time 2019-08-21 20:22
 * description 更好的实现方式-用栈实现队列
 * 此方式的优势在于：
 * 只有当stack2中为空的时候，才去从stack1中迁移数据，减少了数据迁移的次数。
 * 整体的事件复杂度为O(1)
 *
 */
public class StackToQueueBetter {
    private Stack<Integer>stack1 = new Stack<>();
    private Stack<Integer>stack2 = new Stack<>();

    /**
     * 数据压入
     * @param node
     */
    public void push(int node){
        //直接存如到stack1中
        stack1.push(node);
    }

    /**
     * 数据弹出
     * @return
     */
    public int pop(){
        // stack2为空
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }
            // stack2为空，但stack1不为空，则进从stack1中迁移数据
            transfer();
        }
        // 获取到栈顶数据，弹出
        int retNode = stack2.pop();
        System.out.println(retNode);
        return retNode;
    }

    /**
     * 数据迁移，将stack1中的数据，迁移到stack2中
     */
    public void transfer(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    public static void main(String[] args) {
        StackToQueueBetter stackToQueueBetter = new StackToQueueBetter();
        stackToQueueBetter.push(1);
        stackToQueueBetter.push(2);
        stackToQueueBetter.push(3);
        stackToQueueBetter.pop();
        stackToQueueBetter.push(4);
        stackToQueueBetter.push(5);
        stackToQueueBetter.pop();
    }
}


