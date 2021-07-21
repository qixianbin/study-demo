package com.spring.study.designpatterns.compositepattern;

import java.util.ArrayList;
import java.util.List;

public class School extends OrganizationComponent {

    List<OrganizationComponent> organizations = new ArrayList<>();

    protected School(String name, int level) {
        super(name, level);
    }

    @Override
    public void print() {
        System.out.println("--"+getName()+"--");
        for (OrganizationComponent component : organizations) {
            component.print();
        }
    }

    @Override
    public void add(OrganizationComponent component) {
        organizations.add(component);
    }

    @Override
    public void delete(OrganizationComponent component) {
        organizations.remove(component);
    }
}
