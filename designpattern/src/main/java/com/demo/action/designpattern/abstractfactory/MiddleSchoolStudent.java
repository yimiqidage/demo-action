package com.demo.action.designpattern.abstractfactory;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 15:38
 * description
 */
public class MiddleSchoolStudent implements IStudent {
    static final String DESCRIPTION = "This is the Middle School Student";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
