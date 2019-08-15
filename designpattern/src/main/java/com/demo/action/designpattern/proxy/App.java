package com.demo.action.designpattern.proxy;

/**
 * Creator weishi8
 * Date&Time 2019-08-14 19:11
 * description 代理模式
 * 1、代理模式的几个角色：(参照：https://howtodoinjava.com/design-patterns/structural/proxy-design-pattern/)
 *  1、主体对象-Subject：一般是接口，对客户端暴露的可用性功能。
 *  2、真实主体对象-Real Subject：主体对象的具体实现，即实现了Subject的对象；
 *  3、代理-Proxy：通过代理对象，隐藏真实对象。
 * 2、实现步骤：
 *  1、定义Subject角色：Image，为一个接口，定义了display方法；
 *  2、定义Real-Subject角色： RealImage，为Image接口的实现类；
 *  3、定义Proxy角色：ProxyRealImage，也实现了Image接口，但是具体Image接口方法display，是通过调用RealImage的方法来实现的；
 *  4、在 ProxyRealImage 中，通过预定义的 MAX_COUNT，控制对真实对象RealImage的访问次数；
 *  5、定义ImageType，在代理模式中，没有代表其他角色。
 *3、关键点说明：
 *  1、在代理对象 ProxyRealImage 中，也需要实现接口 Image；
 *  2、在代理对象 ProxyRealImage 中，接口 Image 的实现，是调用 RealImage的方法来实现的；
 *  3、ProxyRealImage 的构造函数中，参数也可以修改为 ProxyRealImage(RealImage realImage)，这样代理更加明确；
 *  4、在代理对象 ProxyRealImage 中，可以增加对真实对象 RealImage的访问控制，如限制访问次数。
 * 4、代理模式同装饰器模式的区别：
 *  装饰器模式，侧重于对原有类增加新的功能；代理模式，侧重于对控制对象的访问，如增加白名单、限流等；
 * 5、代理模式的其他说明：（参照 https://en.wikipedia.org/wiki/Proxy_pattern )
 *  1、代理模式可能对客户端隐藏真实的对象；
 *  2、代理模式可能会执行，类似按需加载的优化；
 *  3、代理模式可能会执行额外的 house-keeping 工作，类似审核任务；
 */
public class App {
    public static void main(String[] args) {
        //1、初始化被代理对象RealImage；
        RealImage realImage = new RealImage();
        //2、初始化代理对象 ProxyRealImage；
        ProxyRealImage proxyRealImage = new ProxyRealImage(realImage);
        //3、通过代理对象 ProxyRealImage，调用display方法，在 ProxyRealImage 中会对调用次数进行控制；
        proxyRealImage.display(ImageType.JPEG);
        proxyRealImage.display(ImageType.JPG);
        proxyRealImage.display(ImageType.PNG);
        proxyRealImage.display(ImageType.JPEG);
    }
}
