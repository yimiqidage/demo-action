package com.demo.action.designpattern.chain;

/**
 * Creator weishi8
 * Date&Time 2019-08-26 11:12
 * description 实现类之三：InfoLogger
 */
public class InfoLogger extends AbstractLogger {

    public InfoLogger(){
        // 设置level的值
       this.level = LoggerType.INFO.getLevel();
        // 声明下一个链为ErrorLogger
       this.setNextLogger(new ErrorLogger());
    }

    @Override
    public void write(String message) {
        System.out.println("InfoLogger :"+message);
    }
}
