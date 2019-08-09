package com.demo.action.designpattern.abstractfactory;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 15:40
 * description
 */
public class HighLevelSchoolStudent implements  IStudent {
    static final String DESCRIPTION = "This is the HighLevel School Student";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
