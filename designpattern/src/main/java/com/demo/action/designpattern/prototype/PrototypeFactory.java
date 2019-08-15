package com.demo.action.designpattern.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Creator weishi8
 * Date&Time 2019-08-12 16:33
 * description 原型模式
 * 1、原型模式，在实际项目中，很少单独出现，一般是和工厂方法模式一起出现，通过 clone 的方法创建一个对象；
 * 2、需要实现Cloneable接口（但此接口并无接口方法，只是个标记），如果不实现此接口，则会抛出 CloneNotSupportedException 异常；
 * 3、一般方法，都会命名为clone，可以通过调用Object.clone方法，来实现；
 * 4、如果只是重写了Object.clone方法，但未实现 Cloneable 接口，仍然会抛出 CloneNotSupportedException 异常；
 * 5、个人感觉，在创建对象的时候，原型模式是单例模式的备选模式。
 *
 * 使用场景：
 * 1、类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等。
 * 2、通过 new 产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式。
 *
 * 样例实现逻辑：
 * 1、定义接口IShape，此接口继承了Cloneable接口。同时定义了 copy 的方法，（draw方法可以只做参考用）；
 * 2、定义三个类Circle、Rectangle、Square，实现IShape接口，copy方法通过调用Object.copy方法来实现；
 * 3、PrototypeFactory 原型工厂类，添加了静态的变量 Map<PrototypeType,IShape> prototypes，这样可以在类初始化的时候，就创建好原型类需要的对象；（具体prototypes属性的初始化，可以参照单例模式来实现）
 * 4、通过 PrototypeFactory.getInstance 方法，返回新创建的对应的IShape接口实现类对象。
 *
 *
 * 参照地址：https://howtodoinjava.com/design-patterns/creational/prototype-design-pattern-in-java/
 */
public class PrototypeFactory {

    enum PrototypeType{
        CIRCLE, //圆形
        RECTANGLE, //长方形
        SQUARE //正方形
    }

    private static Map<PrototypeType,IShape> prototypes = new HashMap<>();

    /**
     * 静态代码块，在类加载的时候，就会进行初始化
     */
    static {
        prototypes.put(PrototypeType.CIRCLE,new Circle());
        prototypes.put(PrototypeType.RECTANGLE,new Rectangle());
        prototypes.put(PrototypeType.SQUARE,new Square());
    }

    /**
     * 定义获取对象方法（跟工厂模式很相似）
     * @param prototypeType
     * @return
     * @throws CloneNotSupportedException
     */
    public static IShape getInstance(PrototypeType prototypeType) throws CloneNotSupportedException{
        return prototypes.get(prototypeType).clone();
    }
}
