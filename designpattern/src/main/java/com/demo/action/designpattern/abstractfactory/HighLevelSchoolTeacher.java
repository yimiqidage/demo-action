package com.demo.action.designpattern.abstractfactory;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 15:40
 * description
 */
public class HighLevelSchoolTeacher implements  ITeacher {
    static final String DESCRIPTION = "This is the HighLevel School Teacher";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
