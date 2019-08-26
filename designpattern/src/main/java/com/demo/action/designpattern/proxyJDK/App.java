package com.demo.action.designpattern.proxyJDK;

import java.lang.reflect.Proxy;

/**
 * Creator weishi8
 * Date&Time 2019-08-15 11:39
 * description 使用JDK动态代理，实现代理功能
 * 1、整体步骤：
 *  1、已有接口 Image，已有接口实现 RealImage；
 *  2、自定义处理器 MyInvocationHandler，需要实现 InvocationHandler 接口；
 *      2.1、在处理器中，可以指定方法名称，进行设置：如在调用display方法前，增加日志，耗时等；
 *      2.2、在自定义处理器 MyInvocationHandler 中，增加对被代理类对象的引入（Image接口）；
 *      2.3、在自定义处理器 MyInvocationHandler 中，调用被代理类的方法；
 *  3、通过调用 Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h) 方法，获取到代理类；
 *      如：Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Image.class},myInvocationHandler); 返回的就是 Image.class 的对象；
 *  4、通过返回的代理对象，（如：proxyImage），调用接口方法(如：display）。
 * 2、要求：
 *  1、被代理的类，必须是接口：
 *      如将示例修改为：(RealImage)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{RealImage.class},myInvocationHandler);
 *      则会提示：com.demo.action.designpattern.proxyJDK.RealImage is not an interface
 *  2、处理器类中，可以不用接口Image，用接口实现类RealImage：
 *      例如，可以将 private Image image; 修改为 private RealImage image;
 * 3、特点：
 *  1、动态代理，会在项目根目录下，生成类似 $Proxy0.class 的代理类；
 *      可以通过设置 System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
 *  2、该代理文件是在项目的根目录下，不是在src目录下，也不在classes目录下；
 *  3、如果想设置生成动态代理类的名称，可以通过 ProxyGenerator.generateProxyClass 的方式进行自定义，并且将二进制文件手动保存。
 *  4、生成的代理类，继承 java.lang.reflect.Proxy，同时实现了被代理的接口Image，类定义入下：
 *      public final class $Proxy0 extends Proxy implements Image {
 *
 * 5、参照地址：
 * https://blog.csdn.net/yidianyidi123/article/details/79515035
 * https://www.cnblogs.com/flyingeagle/articles/7103190.html
 *
 */
public class App {
    public static void main(String[] args) {

        // 设置此系统属性,让JVM生成的Proxy类写入文件.保存路径为：com/sun/proxy(如果不存在请手工创建)
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.out.println("代理文件路径："+Proxy.getProxyClass(Image.class.getClassLoader(), Image.class));
        // 方式一：
        // 1、定义真实对象
        Image realImage = new RealImage();
        // 2、声明自定义处理器
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realImage);
        // 3、通过类加载器、类名称、以及处理器，生成代理对象
        Image proxyImage = (Image)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Image.class},myInvocationHandler);
        // 4、调用代理对象的方法
        proxyImage.display(ImageType.JPEG);
        proxyImage.display2();

        // 方式二：
        // 5、将代理生成方式，做为方法，添加到处理器 MyInvocationHandler 中
        Image proxyImage2 = (Image)myInvocationHandler.newProxy(realImage);
        proxyImage2.display(ImageType.JPG);
    }
}
