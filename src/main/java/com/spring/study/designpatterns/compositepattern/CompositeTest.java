package com.spring.study.designpatterns.compositepattern;

public class CompositeTest {
    public static void main(String[] args) {
        OrganizationComponent school = new School("清华大学",1);

        OrganizationComponent college1 = new College("信息学院",2);
        OrganizationComponent college2 = new College("经济学院", 2);

        school.add(college1);
        school.add(college2);

        school.print();

    }
}
