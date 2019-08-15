package com.demo.action.designpattern.prototype;

import com.demo.action.designpattern.prototype.PrototypeFactory.PrototypeType;

/**
 * Creator weishi8
 * Date&Time 2019-08-12 16:37
 * description
 */
public class TestPrototypeFactory {
    public static void main(String[] args) throws CloneNotSupportedException{
        IShape circle = PrototypeFactory.getInstance(PrototypeType.CIRCLE);
        circle.draw();
        IShape rectangle = PrototypeFactory.getInstance(PrototypeType.RECTANGLE);
        rectangle.draw();
        IShape square = PrototypeFactory.getInstance(PrototypeType.SQUARE);
        square.draw();
    }
}
