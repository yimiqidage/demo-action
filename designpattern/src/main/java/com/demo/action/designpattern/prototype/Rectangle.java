package com.demo.action.designpattern.prototype;

/**
 * Creator weishi8
 * Date&Time 2019-08-12 16:26
 * description
 */
public class Rectangle implements IShape {

    @Override
    public IShape clone() throws CloneNotSupportedException {
        System.out.println("Cloning Show object [Rectangle]..");
        return (IShape)super.clone();
    }

    @Override
    public void draw() {
        System.out.println("[Prototype pattern] I am Rectangle:draw");
    }
}
