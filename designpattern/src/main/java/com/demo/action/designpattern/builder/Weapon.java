package com.demo.action.designpattern.builder;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 19:20
 * description
 */
public enum Weapon {

    // 匕首
    DAGGER("dagger"),
    // 刀
    SWORD("sword"),
    // 弓
    BOW("bow");
    private String name;
    Weapon(String name){
        this.name = name;
    }
}
