package com.demo.action.designpattern.chain;

/**
 * Creator weishi8
 * Date&Time 2019-08-26 11:03
 * description 定义抽象类，确定 logMessage 方法的主体流程
 */
public abstract class AbstractLogger {

    protected AbstractLogger nextLogger;

    // 定义为protected，子类可用
    protected int level;

    /**
     * 定义下一个链
     * @param logger
     */
    public void setNextLogger(AbstractLogger logger){
        this.nextLogger = logger;
    }

    /**
     * 定义主体方法
     * @param type
     * @param message
     */
    public void logMessage(LoggerType type,String message){
        if(this.level<=type.getLevel()){
            write(message);
        }
        // 调用下一个链
        if(nextLogger!=null){
            nextLogger.logMessage(type,message);
        }
    }

    /**
     * 抽象方法，需要子类实现
     * @param message
     */
    public abstract  void write(String message);
}
