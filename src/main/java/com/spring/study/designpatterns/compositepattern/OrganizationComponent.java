package com.spring.study.designpatterns.compositepattern;

public abstract class OrganizationComponent {
    private String name;
    private int level;

    protected OrganizationComponent(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public void add(OrganizationComponent component){
        throw new UnsupportedOperationException();
    }

    public void delete(OrganizationComponent component){
        throw new UnsupportedOperationException();
    }

    public abstract void print();

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
