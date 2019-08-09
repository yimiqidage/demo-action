package com.demo.action.designpattern.factory;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 11:31
 * description
 */
public class Rectangle implements IShape {
    @Override
    public void draw() {
        System.out.println("I am Rectangle:draw");
    }
}
