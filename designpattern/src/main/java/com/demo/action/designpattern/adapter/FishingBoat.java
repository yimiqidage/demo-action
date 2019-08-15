package com.demo.action.designpattern.adapter;

/**
 * Creator weishi8
 * Date&Time 2019-08-12 20:59
 * description 渔船
 * 角色：adaptee 被适配的角色，也就是原始的、被依赖的类。一般是外部依赖jar包。就是一个一般的class
 */
public class FishingBoat {
    /**
     * 渔船：航行的方法
     */
    public void sail(){
        System.out.println("Fishing Boat is sail...");
    }
}
