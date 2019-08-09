package com.demo.action.designpattern.abstractfactory;

/**
 * Creator weishi8
 * Date&Time 2019-08-09 15:20
 * description 抽象工厂示例
 */
    public class MiddleSchoolFactory implements SchoolFactory {
        @Override
        public IStudent createStudent() {
            return new MiddleSchoolStudent();
        }

        @Override
        public ITeacher createTeacher() {
            return new MiddleSchoolTeacher();
        }
    }
