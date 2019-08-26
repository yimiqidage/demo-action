package com.demo.action.designpattern.proxyCGLIB;

/**
 * Creator weishi8
 * Date&Time 2019-08-15 15:21
 * description
 */
public class Developer {
    /**
     * public方法，可以被代理
     */
    public void eat(){
        System.out.println("工程师在吃饭...");
    }

    /**
     * final方法，不能被生成的子类覆盖
     */
    public final void work(){
        System.out.println("工程师在工作...");
    }

    /**
     * private方法，不能被生成的子类覆盖
     */
    private void sleep(){
        System.out.println("工程师在睡觉...");
    }
}
