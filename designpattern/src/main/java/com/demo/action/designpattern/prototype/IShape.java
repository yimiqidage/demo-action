package com.demo.action.designpattern.prototype;

/**
 * Creator weishi8
 * Date&Time 2019-08-12 15:53
 * description
 * 1、继承 Cloneable 接口，同时将clone方法，定义为
 */
public interface IShape extends Cloneable{

    IShape clone() throws CloneNotSupportedException ;

    void draw();
}
