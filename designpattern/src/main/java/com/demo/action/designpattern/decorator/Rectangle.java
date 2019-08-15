package com.demo.action.designpattern.decorator;


/**
 * Creator weishi8
 * Date&Time 2019-08-09 11:31
 * description
 * 对应角色：Concrete Comonent
 */
public class Rectangle implements IShape {
    @Override
    public void draw() {
        System.out.println("I am Rectangle:draw");
    }
}
