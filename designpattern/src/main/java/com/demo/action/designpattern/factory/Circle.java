package com.demo.action.designpattern.factory;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 11:30
 * description 圆形实现类
 */
public class Circle implements IShape {
    @Override
    public void draw() {
        System.out.println("I am Circle:draw");
    }
}
