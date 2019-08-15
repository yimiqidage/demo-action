package com.demo.action.designpattern.proxy;

/**
 * Creator weishi8
 * Date&Time 2019-08-14 19:05
 * description
 */
public class ProxyRealImage implements Image {

    // 执行总次数
    private int count=0;
    // 最大执行次数
    public static final int MAX_COUNT = 3;
    // image可以定义为Image类型，或者RealImage类型；
    // 定义为Image类型的好处是，可以代理所有实现了Image接口的实现类；
    // 定义为RealImage的好处是，代理的方式比较明确直观
    private Image image ;

    // 可以通过构造函数的方式，传入Image接口的真实实现类
    public ProxyRealImage(Image image){
        this.image = image;
    }

    /**
     * 代理示例：控制对真实对象RealImage的总访问次数，还可以做限流等其他操作。
     * @param imageType
     */
    @Override
    public void display(ImageType imageType) {
        if(count>=MAX_COUNT){
            System.out.println("达到最大执行次数:"+MAX_COUNT);
            return;
        }
        //只有未到大最大执行次数，才会执行被代理对象的方法
        image.display(imageType);
        count++;
    }
}
