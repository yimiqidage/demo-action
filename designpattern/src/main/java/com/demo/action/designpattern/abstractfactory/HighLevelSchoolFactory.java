package com.demo.action.designpattern.abstractfactory;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 15:37
 * description
 */
public class HighLevelSchoolFactory implements SchoolFactory{
    @Override
    public IStudent createStudent() {
        return new HighLevelSchoolStudent();
    }

    @Override
    public ITeacher createTeacher() {
        return new HighLevelSchoolTeacher();
    }
}
