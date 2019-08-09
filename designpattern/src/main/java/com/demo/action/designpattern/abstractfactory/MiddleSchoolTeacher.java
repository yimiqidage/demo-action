package com.demo.action.designpattern.abstractfactory;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 15:39
 * description
 */
public class MiddleSchoolTeacher implements  ITeacher {

    static final String DESCRIPTION = "This is the Middle School Teacher";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
