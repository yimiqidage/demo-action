package com.demo.action.designpattern.proxyJDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


/**
 * Creator weishi8
 * Date&Time 2019-08-15 11:40
 * description 自定义处理器
 */
public class MyInvocationHandler implements InvocationHandler {

    // 引入被代理的对象
    private Image image;

    public MyInvocationHandler(Image image){
        this.image = image;
    }

    /**
     * 将生成代理类的生成方式，做为方法输出。
     * @param targetObject
     * @return
     */
    public Object newProxy(Object targetObject){
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
    }

    /**
     * 实现接口方法 invoke
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 打印代理类名称：这个代理类不是自己定义的代理类，如 MyInvocationHandler，打印的结果是：com.sun.proxy.$Proxy0
        System.out.println("proxy class name:"+proxy.getClass().getName());
        if(method.getName().equals("display")){
            System.out.println("Use JDK Dynamic Proxy, method name is diplay,args:"+ Arrays.toString(args));
            // 注意，这里invoke方法调用的，是真实对象image的display方法。
            // 这里的image对象，可以是Image对象，也可以是RealImage对象，都试过了。
            return method.invoke(image,args);
        }else {
            System.out.println("method "+method.getName()+" is not support");
        }
        return null;
    }
}
