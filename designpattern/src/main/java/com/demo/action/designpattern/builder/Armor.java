package com.demo.action.designpattern.builder;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 19:15
 * description
 */
public enum Armor {

    CLOTHES("clothes"), LEATHER("leather"), CHAIN_MAIL("chain mail"), PLATE_MAIL("plate mail");

    private String title;

    Armor(String title) {
        this.title = title;
    }
}
