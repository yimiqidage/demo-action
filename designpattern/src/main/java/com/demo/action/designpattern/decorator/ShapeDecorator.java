package com.demo.action.designpattern.decorator;

/**
 * Creator weishi8
 * Date&Time 2019-08-13 18:08
 * description
 * 对应角色：Decoratory
 */
public abstract class ShapeDecorator implements IShape{
    private IShape shape;
    public ShapeDecorator (IShape shape){
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }

}
