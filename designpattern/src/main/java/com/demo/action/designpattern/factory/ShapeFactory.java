package com.demo.action.designpattern.factory;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 11:30
 * description 工厂模式示例：
 * 1、创建一个接口：IShape，代表所有的形状，定义一个draw方法;
 * 2、定义不同的接口实现类，如Circle、Rectangle、Square；
 * 3、定义一个工厂类：ShapeFactory，创建一个方法，返回IShape对象，该方法有一个参数type，用于生成指定类型的IShape实现类的对象；
 * 4、可以直接调用返回对象的draw方法，实现不同的业务逻辑。
 * 5、其他资料中，也使用了运算符（加减乘除，做为工厂实现类的方式）
 * 优点：
 *  1、一个调用者想创建一个对象，只要知道其名称就可以了。
 *  2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。
 *  3、屏蔽产品的具体实现，调用者只关心产品的接口。
 *  缺点：每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加，在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖。
 */
public class ShapeFactory {

    enum ShapeType{
        CIRCLE, //圆形
        RECTANGLE, //长方形
        SQUARE //正方形
    }

    /**
     * 创建ishape实例
     * @param type 创建ishape实例的类型
     * @return
     */
    public static IShape getShape(ShapeType type){
        if(type==null || type.equals("")){
            return null;
        }
        IShape shape = null;
        switch (type){
            case CIRCLE:
                shape = new Circle();
                break;
            case RECTANGLE:
                shape = new Rectangle();
                break;
            case SQUARE:
                shape = new Square();
             break;
        }
        return shape;
    }
}
