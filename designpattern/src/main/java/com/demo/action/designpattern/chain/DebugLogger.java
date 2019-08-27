package com.demo.action.designpattern.chain;

/**
 * Creator weishi8
 * Date&Time 2019-08-26 11:15
 * description 实现类之一 DebugLogger
 */
public class DebugLogger extends  AbstractLogger {

    public DebugLogger(){
        // 设置level的值
        this.level = LoggerType.DEBUG.getLevel();
        // 声明下一个链为InfoLogger
        this.setNextLogger(new InfoLogger());
    }

    @Override
    public void write(String message) {
        System.out.println("DebugLogger :"+message);
    }
}
