package com.demo.action.designpattern.abstractfactory;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 15:51
 * description 应用程序入口
 * 说明：在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。
 * 1、整体构成：SchoolFactory，是学校的集合，学校包含初中 MiddleSchoolFactory 和高中 HighLevelSchool，每种类型的学校，都包含了 IStudent 和 ITeacher 两个接口；
 * 2、整体接口类的对应关系：
 *    SchoolFactory - MiddleSchoolFactory      -- MiddleSchoolStudent --- IStudent
 *                                             -- MiddleSchoolTeacher --- ITeacher
 *                  - HighLevelSchoolFactory   -- HighLevelSchoolStudent --- IStudent
 *                                             -- HighLevelSchoolTeacher --- ITeacher
 * 3、创建一个接口 SchoolFactory，用于抽象学校School这个主体；
 * 4、针对 School，分别有 MiddleSchool，HighLevelSchool，因此分别定义两个实体创建的工厂类：MiddleSchoolFactory、HighLevelSchoolFactory；
 * 5、针对 MiddleSchool，定义两个类 MiddleSchoolStudent、MiddleSchoolTeacher 实现ITeacher、IStudent两个接口；
 * 6、针对 HighLevelSchool，定义两个类 HighLevelSchoolStudent、HighLevelSchoolTeacher 实现ITeacher、IStudent两个接口；
 * 7、调用方式（参照 AbstractFactoryTest)：
 *     7.1 在入口类App中，定义工厂创建方法 createSchoolFactory，通过类型，定义不同的工厂 MiddleSchoolFactory、HighLevelSchoolFactory；
 *     7.2 获取到对应的SchoolFactory后，调用 createStudent方法、createTeacher方法，获取到对应的IStudent、ITeacher；
 */
public class App {

    private IStudent student;
    private ITeacher teacher;

    /**
     * 抽象工厂的入口：根据类型，获取到对应的工厂（即获取到School这个抽象出来的主体）
     * @param schoolType
     * @return
     */
    public static SchoolFactory createSchoolFactory(SchoolType schoolType) {
       switch (schoolType){
           case MIDDLE:
               return new MiddleSchoolFactory();
           case HIGH_LEVEL:
               return new HighLevelSchoolFactory();
           default:
               // 继承自 RuntimeException，属于非检查型异常
               throw new IllegalArgumentException("schoolType not supported.");
       }
    }

    /**
     * 根据SchoolFactory，获取到对应的Student、Teacher对象
     * @param schoolFactory
     */
    public void createSchool(final SchoolFactory schoolFactory){
        this.setStudent(schoolFactory.createStudent());
        this.setTeacher(schoolFactory.createTeacher());
    }

    /**
     * 枚举类，定义了SchoolFactory的类型
     */
    enum SchoolType{
        MIDDLE,
        HIGH_LEVEL
    }

    public IStudent getStudent() {
        return student;
    }

    public void setStudent(IStudent student) {
        this.student = student;
    }

    public ITeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(ITeacher teacher) {
        this.teacher = teacher;
    }

//    public IStudent getStudent(final SchoolFactory schoolFactory) {
//        return schoolFactory.createStudent();
//    }
//
//    public ITeacher getTeacher(final SchoolFactory schoolFactory) {
//        return schoolFactory.createTeacher();
//    }
}
