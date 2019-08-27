package com.demo.action.designpattern.chain;

/**
 * Creator weishi8
 * Date&Time 2019-08-26 11:33
 * description Logger创建工厂，用于创建相应的Logger对象
 */
public class LoggerFactory {

    public static AbstractLogger getLogger(LoggerType type){
        AbstractLogger logger = null;
        if(type==null || type.getLevel()<=0){
            return logger;
        }
        switch (type){
            // 注意，这里不能写成 LoggerType.Debug（不能有LoggerType前缀，因为switch的对象，本身就是LoggerType类型了）
            // 否则会提示 enum switch case must be unqualified name
            case DEBUG:
                logger = new DebugLogger();
                break;
            case INFO:
                logger = new InfoLogger();
                break;
            case ERROR:
                logger = new ErrorLogger();
                break;
        }
        return logger;
    }
}
