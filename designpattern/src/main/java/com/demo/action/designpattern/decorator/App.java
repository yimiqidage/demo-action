package com.demo.action.designpattern.decorator;

/**
 * Creator weishi8
 * Date&Time 2019-08-13 17:09
 * description
 * 装饰者模式入口类
 * 说明：
 *  本示例中，ShapeDecorator 看起来没有太大用处；但确实是装饰者模式中的一个角色：Decorator，装饰者，即具体装饰者实现的一个抽象类。
 *
 * 1、使用场景：
 *   1.1 现在拥有一个对象实例A，并且将另外一个对象实例B放入到实例A中；
 *   1.2 可以通过外部的实例A，访问内部实例B；
 *
 * 2、目的：
 *  1、动态地给一个对象添加一些额外的职责，比如在画图方法（draw）方法中，添加边框颜色设置（setRedBorder）方法；
 *  2、装饰模式是继承关系的一个替代方案，以对客户端透明的方式扩展对象的功能；
 *
 * 3、角色组成：
 *  角色 | 解释 | 说明
 * Comonent | 抽象构建类 | 一般是接口
 * Concrete Comonent | 具体实现类 | 或者叫被装饰的具体实现类
 * Decorator | 抽象装饰类 | 一般是一个抽象类，并且实现了 Comonent 接口的方法
 * Concrete Decorator | 具体装饰类 | 添加了具体的实现逻辑
 *
 * 4、整体逻辑：
 *  1、创建一个接口IShape；
 *  2、创建接口IShape的实现，Rectangle；
 *  3、创建一个抽象装饰者 ShapeDecorator，该装饰者同样实现了接口 IShape；并且添加了一个以IShape为参数的构造函数；
 *  4、创建一个具体装饰者 RedShapeDecorator，该装饰类，添加了具体的装饰逻辑，如：在装饰者的方法实现中，添加额外的处理逻辑，如在draw方法中添加颜色设置（setRedBorder）的方法；
 *  5、调用具体装饰者的draw方法，就添加了原来IShape接口实现类 Rectangle 不具备的逻辑。
 *
 * 5、参考地址：
 * http://www.runoob.com/design-pattern/decorator-pattern.html
 * https://howtodoinjava.com/design-patterns/structural/decorator-design-pattern/
 */
public class App {

    public static void main(String[] args) {

        //1、原始调用方式示例（即不使用装饰者模式）
        IShape rectangle = new Rectangle();
        rectangle.draw();

        //2、添加装饰者设计模式后的调用示例
        IShape redShape = new RedShapeDecorator(rectangle) ;
        redShape.draw();

    }
}
