package com.demo.action.designpattern.abstractfactory;


/**
 * Creator weishi8
 * Date&Time 2019-08-09 15:43
 * description
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        SchoolFactory highLevelSchool = App.createSchoolFactory(App.SchoolType.HIGH_LEVEL);
        System.out.println(highLevelSchool.createStudent().getDescription());
        System.out.println(highLevelSchool.createTeacher().getDescription());

        SchoolFactory middleSchool = App.createSchoolFactory(App.SchoolType.MIDDLE);
        System.out.println(middleSchool.createStudent().getDescription());
        System.out.println(middleSchool.createTeacher().getDescription());
    }
}
