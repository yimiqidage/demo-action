package com.demo.action.designpattern.chain;

/**
 * Creator weishi8
 * Date&Time 2019-08-26 11:15
 * description 实现类之二：ErrorLogger
 */
public class ErrorLogger extends  AbstractLogger {

    public ErrorLogger(){
        // 设置level的值
        this.level = LoggerType.ERROR.getLevel();
        // 声明下一个链为null
        this.setNextLogger(null);
    }

    @Override
    public void write(String message) {
        System.out.println("ErrorLogger :"+message);
    }
}
