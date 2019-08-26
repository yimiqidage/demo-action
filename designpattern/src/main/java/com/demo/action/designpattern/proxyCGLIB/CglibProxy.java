package com.demo.action.designpattern.proxyCGLIB;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Creator weishi8
 * Date&Time 2019-08-15 15:24
 * description 使用cglib生成代理对象
 */
public class CglibProxy implements MethodInterceptor {

    // 被代理的对象
    private Object targetObject;

    // 初始化被代理对象
    public CglibProxy(Object targetObject){
        this.targetObject = targetObject;
    }

    /**
     * 给目标对象创建代理对象
     * @return
     */
    public Object getProxy(){
        // 1、声明增强器
        Enhancer enhancer = new Enhancer();
        // 2、为增强器设置父类：被代理的对象，即增强器父类
        enhancer.setSuperclass(targetObject.getClass());
        // 3、设置回调函数，当前类已经实现了 MethodInterceptor 接口，MethodInterceptor接口，是继承 Callback接口的
        enhancer.setCallback(this);
        // 4、生成代理对象
        return enhancer.create();
    }

    /**
     * 实现拦截方法
     * @param o 指的是生成的动态代理类，如： com.demo.action.designpattern.proxyCGLIB.Developer$$EnhancerByCGLIB$$6a65ee02
     * @param method 被调用的方法
     * @param objects 调用method方法，对应的参数
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 是为了查看，intercept方法中，对应的参数Object，对应的是什么
        // 输出结果为：com.demo.action.designpattern.proxyCGLIB.Developer$$EnhancerByCGLIB$$6a65ee02
        System.out.println("intercept.object:"+o.getClass());

        System.out.println("before "+method.getName()+"...");
        Object object = method.invoke(targetObject,objects);
        System.out.println("after "+method.getName()+"...");
        return object;
    }
}
