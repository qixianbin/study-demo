package com.spring.study.designpatterns.compositepattern;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent {

    List<OrganizationComponent> components = new ArrayList<>();

    protected College(String name, int level) {
        super(name, level);
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void delete(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public void print() {
        System.out.println("----" + getName() + "----");
        for (OrganizationComponent component: components ) {
            component.print();
        }
    }
}
