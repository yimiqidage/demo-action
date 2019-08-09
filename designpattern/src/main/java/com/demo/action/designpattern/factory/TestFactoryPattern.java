package com.demo.action.designpattern.factory;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 11:44
 * description 工厂模式测试类
 */
public class TestFactoryPattern {
    public static void main(String[] args) {
       IShape circle =  ShapeFactory.getShape(ShapeFactory.ShapeType.CIRCLE);
       circle.draw();
       IShape rectangle = ShapeFactory.getShape(ShapeFactory.ShapeType.RECTANGLE);
       rectangle.draw();
       IShape square = ShapeFactory.getShape(ShapeFactory.ShapeType.SQUARE);
       square.draw();
    }
}
