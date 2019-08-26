package com.demo.action.designpattern.proxyCGLIB;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Creator weishi8
 * Date&Time 2019-08-15 15:20
 * description 使用CGLIB，实现代理功能
 * 1、整体介绍：
 *  1、CGLIB是通过对被代理类，生成子类，对父类方法进行重写来实现的；
 *  2、因为是通过继承来实现重写的，因此final方法，以及private方法无法被代理；
 *  3、cglib动态代理是利用asm开源包，对代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。
 * 2、步骤：
 *  1、定义被代理的类 Developer，注意final方法，以及private方法无法被代理；
 *  2、定义代理类，代理类要实现 MethodInterceptor 接口，然后调用targetObject对象，做为方法调用方；
 *  3、返回被生成的对象即可。
 * 3、对比：
 *
 *
 */
public class App {
    public static void main(String[] args) {
        Developer developer = new Developer();
        CglibProxy cglibProxy = new CglibProxy(developer);

        // 1、手动生成代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Developer.class);
        enhancer.setCallback(cglibProxy);
        Developer developerProxy = (Developer) enhancer.create();
        developerProxy.eat();
        developerProxy.work();

//        // 2、调用封装好的代理生成方法
//        Developer developerProxy2 = (Developer)cglibProxy.getProxy();
//        developerProxy2.eat();
//        developerProxy2.work();
    }
}
