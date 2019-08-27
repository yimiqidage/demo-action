package com.demo.action.designpattern.chain;

/**
 * Creator weishi8
 * Date&Time 2019-08-26 11:20
 * description 责任链模式
 *
 * 整体流程：
 * 1、创建一个抽象类 AbstractLogger，做为父类；
 * 2、在抽象类AbstractLogger中，定义方法 logMessage();
 * 3、在抽象类AbstractLogger中，定义抽象方法 write();
 * 4、定义三个子类DebugLogger、ErrorLogger、InfoLogger，继承AbstractLogger，并实现抽象方法 write()；
 * 5、在子类的构造函数中，定义级别（level），以及设置nextLogger（setNextLogger方法），这样的好处是在类初始化后，就已经确定了级别，无需在调用的时候，手动指定next；
 * 6、定义 AbstractLogger 入口，调用 logMessage() 方法；
 *
 * 典型应用：
 * Spring中，增加Filer后，需要调用 filterChain.doFilter(servletRequest,servletResponse); 方法，将当前filter添加到chain中。
 *
 */
public class App {
    public static void main(String[] args) {

        // 1、使用工厂模式，创建相应的Logger对象
//        AbstractLogger logger = LoggerFactory.getLogger(LoggerType.DEBUG);

        // 2、直接声明Debug对象
        AbstractLogger logger = new DebugLogger();

        logger.logMessage(LoggerType.ERROR,"error message");
        System.out.println("--------------");
        logger.logMessage(LoggerType.INFO,"info message");
        System.out.println("--------------");
        logger.logMessage(LoggerType.DEBUG,"debug message");
    }
}
