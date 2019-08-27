package com.demo.action.designpattern.chain;

/**
 * Creator weishi8
 * Date&Time 2019-08-26 11:04
 * description
 */
public enum  LoggerType {

    DEBUG(1),INFO(2),ERROR(3);

    private int level;
    LoggerType(int level){
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
