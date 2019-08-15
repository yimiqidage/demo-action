package com.demo.action.designpattern.adapter;

/**
 * Creator weishi8
 * Date&Time 2019-08-13 14:13
 * description 适配器模式，程序入口
 * 1、示例： new BufferedReader(new InputStreamReader(System.in)); 其中相关角色分配如下：
 * Target : BufferedReader
 * Adapter : InputStreamReader
 * Adaptee ： System.in
 * 2、代码示例角色： new Captain(new FishingBoatAdapter(new FishingBoat()))
 * Target : Captain
 * Adapter : FishingBoatAdapter
 * Adaptee ： FishingBoat
 *
 * 3、Target 目标对象类型；Adapter 适配器，即中间转换的类；Adaptee 被转换对象类型，即由于外部依赖等因素，无需做变动的类；
 * 4、步骤：
 *  4.1 创建接口 RowingBoat，并定义方法 row；
 *  4.2 创建适配器 FishingBoatAdapter，实现接口 RowingBoat，并且增加Adaptee角色的类 FishingBoat 的调用 ；
 *  4.3 在Target的类Captain中，增加构造函数（构造器参数为 RowingBoat 接口）；
 *  4.4 App为统一调用的入口，做为调用示例。
 *
 */
public class App {
    public static void main(String[] args) {
        //1、写法一：明确列出依赖关系
        Captain captain = new Captain(new FishingBoatAdapter(new FishingBoat()));
        captain.row();

        //2、写法二：隐藏Adaptee角色的类
        captain = new Captain(new FishingBoatAdapter());
        captain.row();
    }
}
