package com.demo.action.designpattern.decorator;

/**
 * Creator weishi8
 * Date&Time 2019-08-13 17:11
 * description
 * 对应角色：Concrete Decoratory
 */
public class RedShapeDecorator extends ShapeDecorator {

    private  IShape shape;
    public RedShapeDecorator(IShape shape){
        super(shape);
    }

    @Override
    public void draw() {
        System.out.println("I am RedShapeDecorator:draw");
        setRedBorder(shape);
    }

    public void setRedBorder(IShape shape){
        System.out.println("Border Color: Red");
    }
}
