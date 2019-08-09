package com.demo.action.designpattern.abstractfactory;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 15:34
 * description
 */
public interface SchoolFactory {
    IStudent createStudent();
    ITeacher createTeacher();
}
