package com.demo.action.designpattern.prototype;

/**
 * Creator weishi8
 * Date&Time 2019-08-12 16:23
 * description
 */
public class Circle implements IShape {

    @Override
    public IShape clone() throws CloneNotSupportedException {
        System.out.println("Cloning Show object [Circle]..");
        return (IShape)super.clone();
    }

    @Override
    public void draw() {
        System.out.println("[Prototype pattern] I am Circle:draw");
    }
}
